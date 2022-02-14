package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> listUser();
    void addUser(User user);
    void deleteUser (Long id);
    void updateUser(Long id, User updatedUser);
    User findUserById (Long id);
}
