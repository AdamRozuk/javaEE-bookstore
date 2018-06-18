/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wipb.jee.clientdemo.ejb;

import javax.ejb.Stateless;
import wipb.jee.clientdemo.model.UserCredentials;

@Stateless
public class UserCredentialsDao extends AbstractDao<UserCredentials,Long> {
    public UserCredentialsDao() {
        super(UserCredentials.class);
    }
    public UserCredentials findByUsernameAndPassword(String username, String password) {
        return em.createNamedQuery("UserCredentials.findByUsernameAndPassword",UserCredentials.class)
                .setParameter("un",username)
                .setParameter("pw",password)
                .getResultList().stream().findFirst().orElse(null);
    }
    public UserCredentials findByUsername(String username) {
        return em.createNamedQuery("UserCredentials.findByUsername", UserCredentials.class)
                .setParameter("un", username)
                .getResultList().stream().findFirst().orElse(null);
    }
}
