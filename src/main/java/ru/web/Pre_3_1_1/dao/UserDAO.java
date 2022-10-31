package ru.web.Pre_3_1_1.dao;



import ru.web.Pre_3_1_1.model.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    void delete(Long id);

    void update(Long id, User updateUser);

    User getOne(Long id);

    List<User> getAll();
}
