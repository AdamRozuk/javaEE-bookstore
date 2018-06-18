package wipb.jee.clientdemo.web.controller;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import wipb.jee.clientdemo.model.Book;

@Named
@SessionScoped
public class UserBean implements Serializable {
    private String username;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLogged() {
        return username!=null;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
