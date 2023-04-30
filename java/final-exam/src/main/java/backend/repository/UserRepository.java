package backend.repository;

import entity.Manager;
import entity.Employee;
import entity.User;
import utils.JDBCUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    @Override
    public List<User> findManager() throws SQLException, IOException {
        String sql = "SELECT * FROM `user`";
        try (
                Connection connection = JDBCUtils.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int projectId = rs.getInt("project_id");
                User.Role role = User.Role.valueOf(rs.getString("role"));

                if (role == User.Role.MANAGER) {
                    int exInYear = rs.getInt("ex_in_year");
                    User user = new Manager(id, fullName, email, password, role, exInYear, projectId);
                    users.add(user);
                }
            }
            return users;
        }
    }

    @Override
    public User findByProjectId(int projectId) throws SQLException, IOException {
        String sql = "SELECT * FROM `user` WHERE project_id = ?";
        try (
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql);

        ) {
            pStmt.setInt(1, projectId);
            try (ResultSet rs = pStmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String fullName = rs.getString("full_name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    User.Role role = User.Role.valueOf(rs.getString("role"));
                    if (role == User.Role.EMPLOYEE) {
                        String proSkill = rs.getString("pro_skill");
                        return new Employee(id, fullName, email, password, role,proSkill, projectId);
                    }
                }
                return null;
            }

        }
    }

    @Override
    public User login(String email, String password) throws SQLException, IOException {
        String sql = "SELECT * FROM `user` WHERE email = ? AND `password` = ?";
        try (
                Connection connection = JDBCUtils.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql);
        ) {
            pStmt.setString(1, email);
            pStmt.setString(2, password);
            try (ResultSet rs = pStmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String fullName = rs.getString("full_name");
                    User.Role role = User.Role.valueOf(rs.getString("role"));
                    int projectId = rs.getInt("project_id");
                    if (role == User.Role.MANAGER ) {
                            int exInYear = rs.getInt("ex_in_year");
                            return new Manager(id, fullName, email, password, role, projectId, exInYear);
                        }

                }
            }
        }
        return null;
    }
}



