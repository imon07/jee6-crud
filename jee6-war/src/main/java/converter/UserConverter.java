package converter;

import ejb.UserDao;
import entities.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/9/13
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */

@Named
public class UserConverter implements Converter {

    protected final Log log = LogFactory.getLog(getClass());

    @EJB
    UserDao userDao;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String str) {
        if(str == null) {
            return null;
        }
        int id = Integer.parseInt(str);
        log.info("converter-object: " + str);
        User user = userDao.getById(id);
        if(user != null) {
            log.info("converter-object-user: " + user + " " + user.getId() + " " + user.getFirstName() + " " + user.getLastName() + " "
                     + user.getEmail());
        }
        return user;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
        if(obj == null) {
            return null;
        }
        Integer id = ((User)obj).getId();
        if(id != null) {
            log.info("converter-string: " + id.toString());
        }
        return id == null ? null : id.toString();
    }
}
