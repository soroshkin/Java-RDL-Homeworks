package helpers;

public class Constants {
    private Constants() {
    }

    public static final String CONNECTION = "jdbc:postgresql://localhost:5432/factory";
    public static final String USER = "user";
    public static final String PASSWORD = "password";

    public static final String DEPARTMENTS = "departments";
    public static final String EMPLOYEES = "employees";
    public static final String IT_DEPARTMENT = "IT";
    public static final String SALES_DEPARTMENT = "Sales";
    public static final String RESEARCH_DEPARTMENT = "Research";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS %s CASCADE";

    public static final String CREATE_DEPARTMENTS_TABLE = String.format("CREATE TABLE IF NOT EXISTS  %s " +
            "(id serial PRIMARY KEY," +
            "name varchar NOT NULL UNIQUE, " +
            "manager integer UNIQUE, " +
            "UNIQUE (id, manager))", DEPARTMENTS);
    public static final String CREATE_EMPLOYEES_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s (" +
            "id serial PRIMARY KEY, " +
            "name varchar NOT NULL, " +
            "salary NUMERIC (10,2), " +
            "department integer references departments(id), " +
            "manager int, " +
            "FOREIGN KEY (manager) REFERENCES employees (id), " +
            "FOREIGN KEY (department, manager) REFERENCES departments (id, manager))", EMPLOYEES);
    public static final String CREATE_EMPLOYEES_SALARIES_FUNCTION = "CREATE OR REPLACE FUNCTION return_salaries(id_employee integer) RETURNS TABLE (name varchar, salary NUMERIC(10,2), manager varchar) AS " +
            "$BODY$ " +
            "BEGIN " +
            "IF EXISTS (SELECT employees.manager FROM employees WHERE id = id_employee AND employees.manager = id_employee) " +
            "THEN " +
            "RETURN QUERY " +
            "SELECT employees.name, employees.salary, second.name FROM employees JOIN employees as second ON " +
            "employees.manager = second.id " +
            "WHERE employees.manager = id_employee AND employees.id != id_employee ORDER BY employees.name;" +
            "ELSE " +
            "RETURN QUERY " +
            "SELECT employees.name, employees.salary, second.name FROM employees  join " +
            "employees as second on employees.manager = second.id " +
            "WHERE employees.id = id_employee;" +
            "end if;" +
            "end " +
            "$BODY$ language plpgsql;";

    public static final String INSERT_IN_DEPARTMENTS_TABLE = String.format("INSERT INTO %s (name, manager) values (?, ?)", DEPARTMENTS);
    public static final String INSERT_IN_EMPLOYEES_TABLE = String.format("INSERT into %s (name, salary, department, manager) " +
            "values(?, ?, (SELECT id FROM departments WHERE name = ?), ?)", EMPLOYEES);

    public static final String SQL_QUERY_EMPLOYEES_ORDER_BY_SALARY = "SELECT employees.name, departments.name, employees.salary FROM employees " +
            "JOIN departments ON departments.id=employees.department WHERE departments.name = 'IT' ORDER BY employees.salary";
    public static final String SQL_QUERY_EMPLOYEES_ORDER_BY_NAME = "SELECT employees.name, departments.name, employees.salary FROM employees " +
            "JOIN departments ON departments.id=employees.department WHERE departments.name = 'IT' ORDER BY employees.name";
    public static final String SQL_QUERY_LIST_OF_EMPLOYEES_SALARY_IS_BIGGER = "SELECT employees.name, departments.name, employees.salary " +
            "FROM employees JOIN departments ON employees.department = departments.id " +
            "WHERE employees.salary > (SELECT employees.salary FROM employees where employees.name = '%s')";
    public static final String SQL_QUERY_GET_SALARY = "SELECT name, salary, manager FROM return_salaries(%d)";

    public static final String EMPLOYEE_OR_MANAGER_MESSAGE = "Если ввели ФИО рядового сотрудника, то вывести только его зарплату. Если ввели начальника подразделения - вывести список всех его подчинённых с указанием зарплаты и сортировкой по ФИО";
    public static final String LIST_OF_EMPLOYEES_BY_SALARY_MESSAGE = "Список сотрудников указанного подразделения с сортировкой по зарплате";
    public static final String LIST_OF_EMPLOYEES_BY_NAME_MESSAGE = "Список сотрудников указанного подразделения с сортировкой по ФИО";
    public static final String LIST_OF_EMPLOYEES_SALARY_IS_BIGGER_MESSAGE = "Список сотрудников, у которых оклад больше, чем у заданного (%s)";
}
