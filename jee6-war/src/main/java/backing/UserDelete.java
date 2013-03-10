package backing;

import ejb.UserDao;
import entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * UserInt: sahmed
 * Date: 1/29/13
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class UserDelete {
    private User user;

    protected final Log log = LogFactory.getLog(getClass());

    @EJB
    private UserDao userDao;

    @PostConstruct
    public void init() {

        if(user == null)  {
            log.info("userDelete-start: " + user);
            user = new User();
        }
    }

    public String delete() {
        userDao.delete(user);
        return "User has been deleted";
    }

    public User getUser() {
        log.info("userDelete: " + user);
        log.info("userDelete-id: " + user.getId());
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PreDestroy
    public void close() {
        log.info("userDelete-end: " + user);
        user = null;
    }
}
