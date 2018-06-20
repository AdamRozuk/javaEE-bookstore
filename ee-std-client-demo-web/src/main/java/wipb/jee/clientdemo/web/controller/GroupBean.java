/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wipb.jee.clientdemo.web.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import wipb.jee.clientdemo.ejb.GroupDao;
import wipb.jee.clientdemo.ejb.UserCredentialsDao;

/**
 *
 * @author john
 */
@Named
@ViewScoped
public class GroupBean implements Serializable{
    @EJB
    private GroupDao dao3;
    
    @EJB
    private UserCredentialsDao userCredentialsDao;

    public GroupDao getDao3() {
        return dao3;
    }

    public void setDao3(GroupDao dao3) {
        this.dao3 = dao3;
    }

    public UserCredentialsDao getUserCredentialsDao() {
        return userCredentialsDao;
    }

    public void setUserCredentialsDao(UserCredentialsDao userCredentialsDao) {
        this.userCredentialsDao = userCredentialsDao;
    }
    
    public String getGroupID(Long x){
     //   System.out.println(userCredentialsDao.findById(x).findUserGroubById(x).getGroupname());
        return userCredentialsDao.findById(x).findUserGroubById(x).getGroupname();
    }
    
}
