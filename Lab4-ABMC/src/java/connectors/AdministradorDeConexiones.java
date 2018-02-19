package connectors;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Facundo
 */
public abstract class AdministradorDeConexiones {

    public AdministradorDeConexiones() {
    }
    
    public static Connection getConnection() throws Exception {
        
        String dbDriver = "com.mysql.jdbc.Driver";
        
        String dbConnString = "jdbc:mysql://localhost/j2eeWeb";
        
        String dbUser = "root";
        
        String dbPassword = "";
        
        Class.forName(dbDriver).newInstance();
        
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    }
    
}
