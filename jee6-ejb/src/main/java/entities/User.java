package entities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: sahmed
 * Date: 2/4/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "user")
public class User {
    protected final Log log = LogFactory.getLog(getClass());

    private Integer id;

    @Size(min = 5, message = "First Name Too Short")
    private String firstName;

    @Size(min = 5, message = "Last Name Too Short")
    private String lastName;

    private String email;

    @Id
    @GeneratedValue
    public Integer getId() {
        log.info("user-get-id: " + id);
        return id;
    }

    public void setId(Integer id) {
        log.info("user-set-id: " + id);
        this.id = id;
    }

    public String getFirstName() {
        log.info("user-get-firstName: " + firstName);
        return firstName;
    }

    public void setFirstName(String firstName) {
        log.info("user-set-firstName: " + firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        log.info("user-get-lastName: " + lastName);
        return lastName;
    }

    public void setLastName(String lastName) {
        log.info("user-set-lastName: " + lastName);
        this.lastName = lastName;
    }

    public String getEmail() {
        log.info("user-get-email: " + email);
        return email;
    }

    public void setEmail(String email) {
        log.info("user-set-email: " + email);
        this.email = email;
    }
}
