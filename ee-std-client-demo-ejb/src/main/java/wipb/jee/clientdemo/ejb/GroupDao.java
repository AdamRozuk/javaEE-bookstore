/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wipb.jee.clientdemo.ejb;

import javax.ejb.Stateless;
import wipb.jee.clientdemo.model.UserGroup;

/**
 *
 * @author john
 */

@Stateless
public class GroupDao extends AbstractDao<UserGroup,Long> {
    public GroupDao() {
        super(UserGroup.class);
    } 
}
