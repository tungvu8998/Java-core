package backend.controller;

import backend.repository.IUserRepository;
import backend.repository.UserRepository;
import backend.service.IUserService;
import backend.service.UserService;
import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController implements IUserController {
    private IUserService service = new UserService();



    @Override
    public List<User> findManager() throws SQLException, IOException {
        return service.findManager();
    }

    @Override
    public User findByProjectId(int projectId) throws SQLException, IOException {
        return service.findByProjectId(projectId);
    }


    @Override
    public User login(String email, String password) throws SQLException, IOException {
        return service.login(email,password);
    }
}

