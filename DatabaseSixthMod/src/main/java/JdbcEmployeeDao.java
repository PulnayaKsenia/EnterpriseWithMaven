import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao implements EmployeeDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private String url = "jdbc:postgresql://localhost:5433/Restaurant";
    private String user = "ksenia";
    private String password = "1992";

    @Override
    public Employee load(int id) {
        LOGGER.info("Connecting to database");

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetToEmployee(resultSet);
            } else {
                LOGGER.error("ID: " + id + " not found");
                throw new RuntimeException("Cannot find Employee with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to database: " + url, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAll() {
        LOGGER.info("Connecting to database");
        List<Employee> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            LOGGER.info("Successfully connected to database");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");

            while (resultSet.next()) {
                Employee employee = resultSetToEmployee(resultSet);
                result.add(employee);
            }

        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connecting to database: " + url, e);
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void deleteEmployee(int id) {
        LOGGER.info("Connection to DB");

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            boolean execute = preparedStatement.execute();
            if (execute) {
                LOGGER.info("User was deleted!");
            } else {
                LOGGER.info("User wasn't deleted!");
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while connection to DB " + user, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee createEmployee(Employee employee) {
            LOGGER.info("Connection to DB");

            try (Connection connection = DriverManager.getConnection(url, user, password);

                 PreparedStatement preparedStatement = connection.prepareStatement
                         ("INSERT INTO EMPLOYEE (last_name, first_name, date_of_birth, phone_number, position_id) VALUES(?,?,?,?,1)")) {
                preparedStatement.setString(1, employee.getLastName());
                preparedStatement.setString(2, employee.getFirstName());
                preparedStatement.setDate(3, new java.sql.Date(employee.getDateOfBirth().getTime()));
                preparedStatement.setString(4, employee.getPhoneNumber());

                boolean execute = preparedStatement.execute();
                System.out.println(execute);

            } catch (SQLException e) {
                LOGGER.error("Exception occurred while connection to DB " + user, e);
                throw new RuntimeException(e);
            }
        return null;
    }

    public Employee resultSetToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDateOfBirth(resultSet.getDate("date_of_birth"));
        employee.setPhoneNumber(resultSet.getString("phone_number"));
        employee.setSalary(resultSet.getFloat("salary"));
        employee.setPositionId(resultSet.getInt("position_id"));
        return employee;
    }

//    public JdbcEmployeeDao() {
//        loadDriver();
//    }
//
//    private static void loadDriver() {
//        try {
//            Class.forName("org.postgresql.Driver");
//            LOGGER.info("Driver successfully loaded");
//        } catch (ClassNotFoundException e) {
//            LOGGER.error("Can't find driver: org.postgresql.Driver");
//            throw new RuntimeException(e);
//        }
//    }
}
