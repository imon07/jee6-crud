package ejb;

import entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * Created with IntelliJ IDEA.
 * UserInt: sahmed
 * Date: 1/23/13
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class UserDao {

    protected final Log log = LogFactory.getLog(getClass());

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(User user) {
        log.info("userDao-save-start: " + user);
        entityManager.persist(user);
        log.info("userDao-save-end: " + user);
    }

    public void delete(User user) {
        user = entityManager.find(User.class, user.getId());
        entityManager.remove(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u order by u.id", User.class);
        return query.getResultList();
    }

    public User getById(int userId) {
        return entityManager.find(User.class, userId);
    }
}
