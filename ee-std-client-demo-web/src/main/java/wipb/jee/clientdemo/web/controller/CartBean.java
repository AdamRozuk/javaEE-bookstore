/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wipb.jee.clientdemo.web.controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import other.Email;
import other.SMS;
import wipb.jee.clientdemo.ejb.BookDao;
import wipb.jee.clientdemo.ejb.CartDao;
import wipb.jee.clientdemo.ejb.UserCredentialsDao;
import wipb.jee.clientdemo.model.Book;
import wipb.jee.clientdemo.model.Cart;
import wipb.jee.clientdemo.model.UserGroup;

/**
 *
 * @author dell
 */
@Named
@ViewScoped
public class CartBean implements Serializable{
    @EJB
    private CartDao dao2;
    
    @EJB
    private UserCredentialsDao userCredentialsDao;
    
    @EJB
    private BookDao dao;
    
    @Inject
    private UserBean userBean;
    
    private UserGroup usrGroup;
    
    
    private Cart newCart = new Cart();
    
    public List<Cart> getCarts() {
        return dao2.findAll();
    }
    
    public void addToCart(Book b) {
        newCart = new Cart();
        //newCart.setBook(b);
        //System.out.println("cartBean :" + newCart.getBook().getTitle());
        //newCart.setUser(userCredentialsDao.findByUsernameAndPassword(userCredentialsDao.findByUsername(userBean.getUsername()).getUsername(),userCredentialsDao.findByUsername(userBean.getUsername()).getPassword()));
        //System.out.println(newCart.getUser().getUsername());
        //newCart.setBook(b);
        
        //usrGroup.getUserCredentials().setBook(b);
        //userCredentialsDao.update(usrGroup.getUserCredentials());
        newCart.setBook_ID(b.getId());
        newCart.setUserCredentials_ID(userCredentialsDao.findByUsernameAndPassword(userCredentialsDao.findByUsername(userBean.getUsername()).getUsername(),userCredentialsDao.findByUsername(userBean.getUsername()).getPassword()).getId());
        dao2.save(newCart);
        
    }
    
    public void onRemoveCart(Cart c) {
        dao2.remove(c.getId());
    }
    
     public void onMailSend (String title, String price){
       
       /*       userBean.setEmail("gog172172@gmail.com");
       userBean.setNrtel("786842525");
       email = userBean.getEmail();
       nrtel = userBean.getNrtel();*/
       String email = userCredentialsDao.findByUsernameAndPassword(userCredentialsDao.findByUsername(userBean.getUsername()).getUsername(), userCredentialsDao.findByUsername(userBean.getUsername()).getPassword()).getEmail();
       String nrtel = userCredentialsDao.findByUsernameAndPassword(userCredentialsDao.findByUsername(userBean.getUsername()).getUsername(), userCredentialsDao.findByUsername(userBean.getUsername()).getPassword()).getNrtel();
       //System.out.println("testowanie : " + title + " " + price + " " + email + " " + nrtel);
       String message = "Witaj! \nKupiłeś książkę o tytule: " + title + " w cenie: " + price + "zł.\nDziękujemy za skorzystanie z naszych usług i mamy nadzieję, że korzystanie z nich sprawi, że życie Państwa będzie lepsze i bogatsze.\nŻyczymy miłej lektury!\nKsięgarnia jan&adam";
       Email.Send(email,"Ksiegarnia jan&adam - potwierdzenie zakupu",message);
       //System.out.println("tel :" + nrtel);
       String message2 = "Witaj! Kupiles ksiazke o tytule: " + title + " w cenie: " + price + "zl. Ksiegarnia jan&adam";
       SMS.Send(nrtel,message2);
       
       //Email.Send("proagent333@gmail.com","temat","wiadomosc");
       //SMS.Send("721164152","Wiadomość");
       
    }
}
