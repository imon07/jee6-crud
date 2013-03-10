package backing;

import ejb.UserDao;
import entities.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserInt: sahmed
 * Date: 1/29/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */

@Named
@RequestScoped
public class Index {

    private List<User> userList;

    @EJB
    private UserDao userDAO;

    @PostConstruct
    public void init() {
        userList = userDAO.getAll();
    }

    public List<User> getUserList() {
        return userList;
    }
}
