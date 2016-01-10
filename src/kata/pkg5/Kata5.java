
package kata.pkg5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Kata5 {

    public static void main(String[] args)throws ClassNotFoundException, SQLException, IOException {
        // TODO code application logic here
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cn=DriverManager.getConnection("jdbc:sqlite:People");
        Statement st= cn.createStatement();
        String name ="/Users/iraidacorvo/NetBeansProjects/Kata-5/emails.txt";
        ArrayList<String> mailArray = MailReader.read(name);
        
        for(String mail: mailArray){
            String query = "INSERT INTO Mails(Mail) VALUES ('"+mail+"')";
            st.execute(query);
        }
               
        ResultSet rs = st.executeQuery("SELECT Mail FROM Mails");
        
        while(rs.next()){
            System.out.println( rs.getString("Mail"));
        }
        rs.close();
        st.close();
        cn.close();
    }
}
