/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CCP;

/**
 *
 * @author student
 */
public class SessionManager {
    private static SessionManager instance;
    private String username;
 

    private SessionManager() {
        // Private constructor to enforce singleton pattern
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    
        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }
    
}

