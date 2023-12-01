/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Koneksi {
   private static Connection Koneksi;
   public static Connection getKoneksi(){
       if(Koneksi==null){
           try{
               String url;
               url="jdbc:mysql://localhost:3306/input_data_karyawan";
               String username = "root";
               String password = "";
               DriverManager.registerDriver(new com.mysql.jdbc.Driver());
               Koneksi=DriverManager.getConnection(url, username, password);
           }catch (SQLException t){
               JOptionPane.showMessageDialog(null, "Error Koneksi");
           }
       }return Koneksi;
    }static Object getConnection(){
         throw new UnsupportedOperationException("Not yet implemented");
    }
}
