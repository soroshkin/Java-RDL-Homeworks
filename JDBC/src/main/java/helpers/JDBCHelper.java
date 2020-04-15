package helpers;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Deque;

import static helpers.Constants.*;
import static helpers.Constants.RESEARCH_DEPARTMENT;

public class JDBCHelper {
    private JDBCHelper() {
    }

    public static void createTables(Connection connection) {
        Deque<String> queries = new ArrayDeque<>();
        queries.add(dropTable(DEPARTMENTS));
        queries.add(dropTable(EMPLOYEES));
        queries.add(CREATE_DEPARTMENTS_TABLE);
        queries.add(CREATE_EMPLOYEES_TABLE);
        queries.add(CREATE_EMPLOYEES_SALARIES_FUNCTION);

        queries.forEach(query -> {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static String dropTable(String name) {
        return String.format(DROP_TABLE, name);
    }

    public static void populateDepartmentsTable(PreparedStatement preparedStatement) throws SQLException {
        insertInDepartmentsTable(preparedStatement, IT_DEPARTMENT, 1);
        insertInDepartmentsTable(preparedStatement, SALES_DEPARTMENT, 3);
        insertInDepartmentsTable(preparedStatement, RESEARCH_DEPARTMENT, 5);
        preparedStatement.executeBatch();
    }

    public static void insertInDepartmentsTable(PreparedStatement preparedStatement, String department, int managerId) throws SQLException {
        preparedStatement.setString(1, department);
        preparedStatement.setInt(2, managerId);
        preparedStatement.addBatch();
    }

    public static void populateEmployeesTable(PreparedStatement preparedStatement) throws SQLException {
        insertInEmployeesTable(preparedStatement, "semen", 100, IT_DEPARTMENT, 1);
        insertInEmployeesTable(preparedStatement, "boris", 200, IT_DEPARTMENT, 1);
        insertInEmployeesTable(preparedStatement, "olga", 300, SALES_DEPARTMENT, 3);
        insertInEmployeesTable(preparedStatement, "mark", 400, SALES_DEPARTMENT, 3);
        insertInEmployeesTable(preparedStatement, "luka", 500, RESEARCH_DEPARTMENT, 5);
        insertInEmployeesTable(preparedStatement, "vasya", 600, RESEARCH_DEPARTMENT, 5);
        insertInEmployeesTable(preparedStatement, "chris", 700, RESEARCH_DEPARTMENT, 5);
        insertInEmployeesTable(preparedStatement, "roman", 800, RESEARCH_DEPARTMENT, 5);
        preparedStatement.executeBatch();
    }

    public static void insertInEmployeesTable(PreparedStatement preparedStatement, String name, int salary, String department, int managerId) throws SQLException {
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, salary);
        preparedStatement.setString(3, department);
        preparedStatement.setInt(4, managerId);
        preparedStatement.addBatch();
    }

    public static void testDB(Connection connection) throws SQLException {
        printQueriesResultWithoutParameters(connection, SQL_QUERY_EMPLOYEES_ORDER_BY_SALARY, LIST_OF_EMPLOYEES_BY_SALARY_MESSAGE);
        printQueriesResultWithoutParameters(connection, SQL_QUERY_EMPLOYEES_ORDER_BY_NAME, LIST_OF_EMPLOYEES_BY_NAME_MESSAGE);
        String employeeName = "boris";
        printQueriesResultWithParameter(connection, SQL_QUERY_LIST_OF_EMPLOYEES_SALARY_IS_BIGGER, employeeName, String.format(LIST_OF_EMPLOYEES_SALARY_IS_BIGGER_MESSAGE, employeeName));
        int employeeId = 5;
        printGetSalaryFunctionResult(connection, SQL_QUERY_GET_SALARY, employeeId, EMPLOYEE_OR_MANAGER_MESSAGE + "\nManager");
        employeeId = 6;
        printGetSalaryFunctionResult(connection, SQL_QUERY_GET_SALARY, employeeId, EMPLOYEE_OR_MANAGER_MESSAGE + "\nEmployee");
    }

    public static void printQueriesResultWithoutParameters(Connection connection, String query, String message) {
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            printResult(resultSet, message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printQueriesResultWithParameter(Connection connection, String query, String parameter, String message) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, parameter);
            statement.execute();
            ResultSet resultSet = statement.executeQuery();
            printResult(resultSet, message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printGetSalaryFunctionResult(Connection connection, String query, int employeeId, String message) {
        try (CallableStatement statement = connection.prepareCall(query)) {
            statement.setInt(1, employeeId);
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            printResult(resultSet, message);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printResult(ResultSet resultSet, String message) throws SQLException {
        System.out.println(message);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        String outputStringFormat = "%-8s%-12s%-15s%n";
        System.out.printf(outputStringFormat, resultSetMetaData.getColumnName(1), resultSetMetaData.getColumnName(2), resultSetMetaData.getColumnName(3));
        while (resultSet.next()) {
            System.out.printf(outputStringFormat, resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
        }
    }
}
