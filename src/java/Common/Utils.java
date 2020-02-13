/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Models.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan Cruz
 */
public class Utils {
    
    public static boolean isValidSession(HttpServletRequest request)
    {
        HttpSession objSession = request.getSession();
        Session userSession = (Session)objSession.getAttribute("session"); 

        if(userSession == null) {
            return false;
        }
        else
        {
            return true;
        }
    }
    
}
