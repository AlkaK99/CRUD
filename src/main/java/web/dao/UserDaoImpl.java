package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUser() {
        return (entityManager.createQuery("select u from User u").getResultList());
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(findUserById(id));

    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User oldUser = findUserById(id);
        oldUser.setFirstname(updatedUser.getFirstname());
        oldUser.setLastname(updatedUser.getLastname());
        oldUser.setAge(updatedUser.getAge());
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}
