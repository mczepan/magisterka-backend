package pl.mczepan.mgrapp.model.token;

import pl.mczepan.mgrapp.model.user.dao.DAOUser;

import javax.persistence.*;

@Entity
@Table(name = "token")
public class MailToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @OneToOne
    private DAOUser user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DAOUser getUser() {
        return user;
    }

    public void setUser(DAOUser user) {
        this.user = user;
    }
}
