package tuvet;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector_DB {
    
    public static Connection obj;
    
    public Conector_DB(){
    obj = null;
       
    }   
    public Connection getConnection(){
        return obj;
    }
    public Connection conectar(String Nombre_db){
         try {
            Class.forName("com.mysql.jdbc.Driver");
            obj = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/"+Nombre_db,"root","");
            if(obj != null){
                System.out.println("Conexión exitosa..");
            }
        } catch (ClassNotFoundException | SQLException e) {
           
                System.out.println("Conexión fallida.."+e);
            
        }
        return obj ;
        
    }
    public void desconectar(){
     obj = null;
     if(obj == null){
         System.out.println("Conexión finalizada..");
    }
}
    
}
