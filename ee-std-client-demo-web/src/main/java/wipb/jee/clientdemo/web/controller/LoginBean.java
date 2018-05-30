/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wipb.jee.clientdemo.web.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;

import wipb.jee.clientdemo.ejb.UserCredentialsDao;
import wipb.jee.clientdemo.web.util.JSF;

@Named
@ViewScoped
public class LoginBean implements Serializable {

    @Inject
    private UserBean userBean;

    @EJB
    private UserCredentialsDao userCredentialsDao;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // akcja logowania
    public void login() throws IOException, ServletException {
        if (userCredentialsDao.findByUsernameAndPassword(username, password) != null) {
            userBean.setUsername(username);
            JSF.redirect("book/book_list.xhtml");
        } else {
            JSF.addErrorMessage("Invalid credentials");
        }
    }
    // akcja wylogowania
    public void logout() throws IOException {
        JSF.invalidateSession();
        JSF.redirect("index.xhtml");
    }


}
