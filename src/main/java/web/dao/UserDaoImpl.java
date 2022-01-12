package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unckecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User userUpdate) {
        User user = getUserById(id);
        user.setName(userUpdate.getName());
        user.setSurname(userUpdate.getSurname());
        user.setPosition(userUpdate.getPosition());
        user.setSalary(userUpdate.getSalary());
    }

    @Override
    public void delete(Long id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }
}
