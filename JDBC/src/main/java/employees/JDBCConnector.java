package employees;

import java.sql.*;

import static helpers.Constants.*;
import static helpers.JDBCHelper.*;

public class JDBCConnector {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(CONNECTION, USER, PASSWORD);
             PreparedStatement insertInEmployeesStatement = connection.prepareStatement(INSERT_IN_EMPLOYEES_TABLE);
             PreparedStatement insertInDepartmentsTableStatement = connection.prepareStatement(INSERT_IN_DEPARTMENTS_TABLE)) {
            createTables(connection);

            populateDepartmentsTable(insertInDepartmentsTableStatement);

            populateEmployeesTable(insertInEmployeesStatement);

            testDB(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}