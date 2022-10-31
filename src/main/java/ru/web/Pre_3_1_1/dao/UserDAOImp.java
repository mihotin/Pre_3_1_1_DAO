package ru.web.Pre_3_1_1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.web.Pre_3_1_1.model.User;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        User deleteUser = entityManager.find(User.class, id);
        entityManager.remove(deleteUser);
    }

    @Override
    public void update(Long id, User updateUser) {
        User userToBeUpdate = getOne(id);
        userToBeUpdate.setFirstName(updateUser.getFirstName());
        userToBeUpdate.setLastName(updateUser.getLastName());
        userToBeUpdate.setEmail(updateUser.getEmail());

    }

    @Override
    public User getOne(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT c FROM User c", User.class).getResultList();
    }
}
