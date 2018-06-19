package wipb.jee.clientdemo.web.controller;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import wipb.jee.clientdemo.model.Book;
import wipb.jee.clientdemo.model.UserGroup;

@Named
@SessionScoped
public class UserBean implements Serializable {
    private String username;
    private Long id;
    private UserGroup usergroup;


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

    public UserGroup getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(UserGroup usergroup) {
        this.usergroup = usergroup;
    }
    
    
}
