
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
     public static Connection getConnection() throws SQLException, ClassNotFoundException {

        final String driver = "oracle.jdbc.driver.OracleDriver";
        final String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "system";
        String senha = "cesar";
        Class.forName(driver);
        System.out.println("carregou o driver");

        return DriverManager.getConnection(url, usuario, senha);


    }
    
}
