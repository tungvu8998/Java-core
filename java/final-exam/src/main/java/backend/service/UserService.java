package backend.service;

import backend.repository.IUserRepository;
import backend.repository.UserRepository;
import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserRepository, IUserService {
    private IUserRepository repo = new UserRepository();


    @Override
    public List<User> findManager() throws SQLException, IOException {
        return repo.findManager();
    }

    @Override
    public User findByProjectId(int projectId) throws SQLException, IOException {
        return repo.findByProjectId(projectId);
    }

    @Override
    public User login(String email, String password) throws SQLException, IOException {
        return repo.login(email,password);
    }
}

