package helpers;

public class SQLQueryHelper {
    private SQLQueryHelper() {
    }

    public static String dropTable(String name) {
        return String.format("DROP TABLE IF EXISTS %s CASCADE", name);
    }

    public static String createDepartmentsTable() {
        return "CREATE TABLE IF NOT EXISTS  departments " +
                "(name varchar NOT NULL PRIMARY KEY, manager integer, UNIQUE (manager), UNIQUE (name, manager))";
    }

    public static String createEmployeesTable() {
        return "CREATE TABLE IF NOT EXISTS employees (" +
                "id serial PRIMARY KEY, " +
                "name varchar NOT NULL, " +
                "salary NUMERIC (10,2), " +
                "department varchar references departments(name), " +
                "manager int references employees(id), " +
                "FOREIGN KEY (department, manager) references departments (name, manager))";
    }

    public static String insertInDepartmentsTable(String tableName, String department, int managerId) {
        return String.format("INSERT INTO %s values ('%s', %d)", tableName, department, managerId);
    }

    public static String insertInEmployeesTable(String tableName, String name, int salary, String department, int managerId) {
        return String.format("INSERT into %s (name, salary, department, manager) values('%s', %d, '%s', %d)",
                tableName,
                name,
                salary,
                department,
                managerId);
    }

    public static String createEmployeesSalariesSQLFunction() {
        return "CREATE OR REPLACE FUNCTION return_salaries(id_employee integer) RETURNS TABLE (name varchar, salary NUMERIC(10,2), manager varchar) AS " +
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
                " WHERE employees.id = id_employee;" +
                "end if;" +
                "end " +
                "$BODY$ language plpgsql;";
    }
}
