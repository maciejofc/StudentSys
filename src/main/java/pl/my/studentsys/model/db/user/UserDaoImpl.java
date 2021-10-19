package pl.my.studentsys.model.db.user;

import pl.my.studentsys.model.UserDataModelManager;
import pl.my.studentsys.model.db.JdbcDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String SELECT_USER_QUERY = "SELECT * FROM users WHERE email = ?";
    private static final String INSERT_QUERY = "INSERT INTO users values (?,?,?,?)";
    JdbcDao jdbcDao = new JdbcDao();


    @Override
    public void deleteUser(UserDataModelManager user) throws SQLException {

    }

    @Override
    public boolean updateUser(UserDataModelManager user) throws SQLException {
        return false;
    }

    @Override
    public List<UserDataModelManager> selectAllUsers() {
        return null;
    }

    @Override
    public UserDataModelManager selectUser(int id) {
        return null;
    }

    @Override
    public void createUser(String fullname, String email, String password)  {



            try (Connection connection = jdbcDao.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
                    preparedStatement.setString(1,null);
                    preparedStatement.setString(2,fullname);
                    preparedStatement.setString(3,email);
                    preparedStatement.setString(4,password);
                    preparedStatement.execute();
            } catch (SQLException e) {
                printSQLException(e);
            }


    }

    @Override
    public UserDataModelManager selectUserByLogin(String email) throws SQLException {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = jdbcDao.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_QUERY)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullname = resultSet.getString("fullname");
                String login = resultSet.getString("email");
                String password = resultSet.getString("password");
                System.out.println("login= " + login + ",password=" + password);
                return new UserDataModelManager(id, fullname, login, password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}