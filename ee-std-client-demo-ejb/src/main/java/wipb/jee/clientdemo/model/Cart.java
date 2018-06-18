/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wipb.jee.clientdemo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author dell
 */
@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long Book_ID;
    private Long UserCredentials_ID;
    //@ManyToOne
    //private Book book;
    //@ManyToOne
    //private UserCredentials user;
    
    /* public Book getBook() {
    return book;
    }
    
    public void setBook(Book book) {
    this.book = book;
    }*/
    
    /*    public UserCredentials getUser() {
    return user;
    }
    
    public void setUser(UserCredentials user) {
    this.user = user;
    }*/

    public Long getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(Long Book_ID) {
        this.Book_ID = Book_ID;
    }

    public Long getUserCredentials_ID() {
        return UserCredentials_ID;
    }

    public void setUserCredentials_ID(Long UserCredentials_ID) {
        this.UserCredentials_ID = UserCredentials_ID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
