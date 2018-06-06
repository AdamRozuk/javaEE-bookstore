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
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import wipb.jee.clientdemo.ejb.BookDao;
import wipb.jee.clientdemo.model.Book;

@Named
@ViewScoped
public class BookBean implements Serializable {    
    @EJB
    private BookDao dao;
    
    private Book newBook = new Book();

    public List<Book> getBooks() {
        return dao.findAll();
    }
    
    public void onRemoveBook(Book b) {
        dao.remove(b.getId());
    }
    
    public void onUpdateBook(Book b) {
        newBook = dao.findById(b.getId());
        System.out.println("updatebook_qwertyasdfgh" + b.getId());
    }
    
    public void onBookAdd() {
        newBook = new Book();
    }
    
    public void onBookAdded(Integer ou) {
        if(ou.equals(0)){
            dao.save(newBook);
            RequestContext.getCurrentInstance().execute("PF('BookDlg').hide()");
        }
        else {
            dao.update(newBook);
            RequestContext.getCurrentInstance().execute("PF('BookDlg').hide()");
            System.out.println("qwertyasdfgh" + ou);
        }
    }  

    public Book getNewBook() {
        return newBook;
    }

    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }   
}
