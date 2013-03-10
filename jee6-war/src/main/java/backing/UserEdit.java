package backing;

import ejb.UserDao;
import entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * UserInt: sahmed
 * Date: 1/29/13
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class UserEdit {

    private User user;

    protected final Log log = LogFactory.getLog(getClass());

    @EJB
    private UserDao userDAO;

    @PostConstruct
    public void init() {
        if(user == null)  {
            log.info("userEdit-start: " + user);
            user = new User();
        }
    }

    public String saveUser() {
        if (user.getId() != null) {
            log.info("userEdit-update: " + user);
            userDAO.update(user);
        }
        else {
            log.info("userEdit-save: " + user);
            userDAO.save(user);
        }

        return "index.xhtml?faces-redirect=true";
    }

    public void setUser(User user) {
        log.info("userEdit-set-user: " + user);
        this.user = user;
    }

    public User getUser() {
        log.info("userEdit-get-user: " + user);
        return user;
    }
}
