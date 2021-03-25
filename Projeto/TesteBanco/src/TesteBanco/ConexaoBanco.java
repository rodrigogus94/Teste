/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoBanco {
    private Connection con;
		
		public ConexaoBanco (){
		
		try { 
			String driverName = "oracle.jdbc.driver.OracleDriver"; 
			Class.forName(driverName);
			con = DriverManager.getConnection(
				"jdbc:oracle:thin:@127.0.0.1:1521:XE","system","cesar");		
		} 
		catch(Exception e) { 
			System.out.println("Houve um erro ao carregar:" + e.getMessage()); 
		} 
	 	} 

	public void  consultar() throws SQLException{
		Statement stm = null;
		try{
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from cliente"); 	
			while(rs.next()) { 
				System.out.println("Mostrando a primeira coluna do resultado \n" + rs.getInt("id"));
                                System.out.println("Mostrando a primeira coluna do resultado \n" + rs.getString("nome"));
                                System.out.println("Mostrando a primeira coluna do resultado \n" + rs.getInt("cpf"));
			}
		} catch(Exception e) { 
			System.out.println("Houve um erro:" + e.getMessage()); 
		} finally {
			stm.close();
		}
	}
	public void  inserir(String nome,int idade) throws SQLException{
		Statement stm = null;
		try {
			stm = con.createStatement();
			String insert ="insert into cliente values (0,"+"'"+nome+"'"+","+idade+")";
			stm.executeUpdate (insert); 
		} catch(Exception e) { 
			System.out.println("Houve um erro:" + e.getMessage()); 
		} finally {
			stm.close();
		}
	}
        
       public void deletar(int id) throws SQLException{
           Statement stm = null;
		try {
			stm = con.createStatement();
			String delete ="delete from cliente where id = "+id;
			stm.executeUpdate (delete); 
		} catch(Exception e) { 
			System.out.println("Houve um erro:" + e.getMessage()); 
		} finally {
			stm.close();
		}
       }
       
       public void alterarNome(int id, String novonome) throws SQLException{
           Statement stm = null;
		try {
			stm = con.createStatement();
			String alterar ="update cliente set nome = "+"'"+novonome+"'"+"where id = "+id;
			stm.executeUpdate (alterar); 
		} catch(Exception e) { 
			System.out.println("Houve um erro:" + e.getMessage()); 
		} finally {
			stm.close();
		}
       }
       
      
       }


