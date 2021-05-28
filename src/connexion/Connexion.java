/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Soft developpers
 */
public class Connexion {
    
    private static Connection con;
    
    public static Connection cx(){
        
        try {
            con=DriverManager.getConnection("jdbc:sqlserver://BIENFAIT\\SA;databaseName=Presence", "sa", "bb");
        } catch (Exception e) {
        }
        return con;
    }
}
