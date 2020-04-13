package employees;

import java.sql.*;

import static helpers.SQLQueryHelper.*;

public class PostgresqlConnector {
    private static final String EMPLOYEE_OR_MANAGER_MESSAGE = "Если ввели ФИО рядового сотрудника, то вывести только его зарплату. Если ввели начальника подразделения - вывести список всех его подчинённых с указанием зарплаты и сортировкой по ФИО";
    private static final String LIST_OF_EMPLOYEES_BY_SALARY = "Список сотрудников указанного подразделения с сортировкой по зарплате";
    private static final String LIST_OF_EMPLOYEES_BY_NAME = "Список сотрудников указанного подразделения с сортировкой по ФИО";
    private static final String LIST_OF_EMPLOYEES_SALARY_IS_BIGGER = "Список сотрудников, у которых оклад больше, чем у заданного (%s)";
    private static final String DEPARTMENTS = "departments";
    private static final String EMPLOYEES = "employees";

    private static final String SQL_QUERY_EMPLOYEES_ORDER_BY_SALARY = "SELECT name, department, salary FROM employees WHERE department = 'IT' ORDER BY salary";
    private static final String SQL_QUERY_EMPLOYEES_ORDER_BY_NAME = "SELECT name, department, salary FROM employees WHERE department = 'IT' ORDER BY name";
    private static final String SQL_QUERY_LIST_OF_EMPLOYEES_SALARY_IS_BIGGER = "SELECT name, department, salary FROM employees WHERE salary > (SELECT salary FROM employees where name = '%s')";
    private static final String SQL_QUERY_GET_SALARY = "SELECT name, salary, manager FROM return_salaries(%d)";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String connectionString = "jdbc:postgresql://localhost:5432/factory";
        try (Connection connection = DriverManager.getConnection(connectionString, "user", "password");
             Statement statement = connection.createStatement();) {

            statement.addBatch(dropTable(DEPARTMENTS));
            statement.addBatch(dropTable(EMPLOYEES));

            statement.addBatch(createDepartmentsTable());
            statement.addBatch(createEmployeesTable());

            String salesDepartment = "Sales";
            String researchDepartment = "Research";
            String itDepartment = "IT";
            statement.addBatch(insertInDepartmentsTable(DEPARTMENTS, itDepartment, 1));
            statement.addBatch(insertInDepartmentsTable(DEPARTMENTS, salesDepartment, 3));
            statement.addBatch(insertInDepartmentsTable(DEPARTMENTS, researchDepartment, 5));

            statement.addBatch(insertInEmployeesTable(EMPLOYEES, "semen", 100, itDepartment, 1));
            statement.addBatch(insertInEmployeesTable(EMPLOYEES, "boris", 200, itDepartment, 1));
            statement.addBatch(insertInEmployeesTable(EMPLOYEES, "olga", 300, salesDepartment, 3));
            statement.addBatch(insertInEmployeesTable(EMPLOYEES, "mark", 400, salesDepartment, 3));
            statement.addBatch(insertInEmployeesTable(EMPLOYEES, "luka", 500, researchDepartment, 5));
            statement.addBatch(insertInEmployeesTable(EMPLOYEES, "vasya", 600, researchDepartment, 5));
            statement.addBatch(insertInEmployeesTable(EMPLOYEES, "chris", 700, researchDepartment, 5));
            statement.addBatch(insertInEmployeesTable(EMPLOYEES, "roman", 800, researchDepartment, 5));

            statement.executeBatch();
            statement.execute(createEmployeesSalariesSQLFunction());

            ResultSet resultSet = statement.executeQuery(SQL_QUERY_EMPLOYEES_ORDER_BY_SALARY);
            printResult(resultSet, LIST_OF_EMPLOYEES_BY_SALARY);

            resultSet = statement.executeQuery(SQL_QUERY_EMPLOYEES_ORDER_BY_NAME);
            printResult(resultSet, LIST_OF_EMPLOYEES_BY_NAME);

            String employeeName = "boris";
            resultSet = statement.executeQuery(String.format(SQL_QUERY_LIST_OF_EMPLOYEES_SALARY_IS_BIGGER, employeeName));
            printResult(resultSet, String.format(LIST_OF_EMPLOYEES_SALARY_IS_BIGGER, employeeName));

            int employeeId = 5;
            resultSet = statement.executeQuery(String.format(SQL_QUERY_GET_SALARY, employeeId));
            printResult(resultSet, EMPLOYEE_OR_MANAGER_MESSAGE + "\nManager");

            employeeId = 1;
            resultSet = statement.executeQuery(String.format(SQL_QUERY_GET_SALARY, employeeId));
            printResult(resultSet, EMPLOYEE_OR_MANAGER_MESSAGE + "\nEmployee");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printResult(ResultSet resultSet, String message) throws SQLException {
        System.out.println(message);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        String outputStringFormat = "%-8s%-12s%-15s%n";
        System.out.printf(outputStringFormat, resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2), resultSetMetaData.getColumnName(3));
        while (resultSet.next()) {
            System.out.printf(outputStringFormat, resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
        }
    }
}
