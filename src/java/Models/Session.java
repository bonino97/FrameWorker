/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDateTime;

/**
 *
 * @author Juan Cruz
 */
public class Session {
    
    private User logedUser;
    private LocalDateTime logedDate;

    public User getLogedUser() {
        return logedUser;
    }

    public void setLogedUser(User logedUser) {
        this.logedUser = logedUser;
    }

    public LocalDateTime getLogedDate() {
        return logedDate;
    }

    public void setLogedDate(LocalDateTime logedDate) {
        this.logedDate = logedDate;
    }
    
    
    
}
