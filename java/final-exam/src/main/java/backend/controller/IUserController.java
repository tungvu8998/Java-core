package backend.controller;

import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUserController {
    List<User> findManager() throws SQLException, IOException;

    User findByProjectId(int projectId) throws SQLException, IOException;

    User login(String email, String password) throws SQLException, IOException;
}
