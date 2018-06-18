/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wipb.jee.clientdemo.ejb;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import wipb.jee.clientdemo.model.Cart;

/**
 *
 * @author dell
 */

@Stateless
public class CartDao extends AbstractDao<Cart,Long> {
    public CartDao() {
        super(Cart.class);
    } 
}