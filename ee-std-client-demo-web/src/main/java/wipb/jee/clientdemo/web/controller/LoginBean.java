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
import wipb.jee.clientdemo.model.UserCredentials;
import wipb.jee.clientdemo.ejb.UserCredentialsDao;
import wipb.jee.clientdemo.model.Book;
import wipb.jee.clientdemo.model.Cart;
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
    private Cart cart;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public void addToCart(Book b) throws IOException, ServletException {
        System.out.println("LoginBean " + b.getTitle() + " " + userBean.getUsername());
        //user.add(b);
        System.out.println("usename via dao " + userCredentialsDao.findByUsername(userBean.getUsername()).getUsername());
        System.out.println("password via dao " + userCredentialsDao.findByUsername(userBean.getUsername()).getPassword());
        //userCredentialsDao.findByUsernameAndPassword(userCredentialsDao.findByUsername(userBean.getUsername()).getUsername(),userCredentialsDao.findByUsername(userBean.getUsername()).getPassword()).addBook(b);
        //System.out.println(userCredentialsDao.findByUsernameAndPassword(userCredentialsDao.findByUsername(userBean.getUsername()).getUsername(),userCredentialsDao.findByUsername(userBean.getUsername()).getPassword()).getUserCart());
        //cart.setUser(userCredentialsDao.findByUsernameAndPassword(userCredentialsDao.findByUsername(userBean.getUsername()).getUsername(),userCredentialsDao.findByUsername(userBean.getUsername()).getPassword()));
        //cart.setBook(b);
    }
    
    // akcja logowania
    public void login() throws IOException, ServletException {
        if (userCredentialsDao.findByUsernameAndPassword(username, password) != null) {
            userBean.setUsername(username);
            userBean.setId(userCredentialsDao.findByUsernameAndPassword(userCredentialsDao.findByUsername(userBean.getUsername()).getUsername(),userCredentialsDao.findByUsername(userBean.getUsername()).getPassword()).getId());
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
