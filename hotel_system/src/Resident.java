
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Resident {
             My_Connection my_Connection = new My_Connection();
    //Function to add a Resident
      public boolean addResident(String FName,String LName, String Phone, String Email)
      {
         
          
          PreparedStatement st ;
          ResultSet rs;
          String addQuery = "INSERT INTO `resident`(`id`, `FName`, `LName`, `PhoneNo`, `Emai`) VALUES (default,?,?,?,?)";
          try {
              st = my_Connection.CreateConnection().prepareStatement(addQuery);
              
              st.setString(1, FName);
              st.setString(2, LName);
              st.setString(3, Phone);
              st.setString(4, Email);
              
             if(st.executeUpdate()> 0)
                 {
                     return true;
                 }
             else{
                     return false;       
                  }
                 
          } catch (SQLException ex) {
              Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
              return false;
          }
          
         
      }
      // To display Resident Name in GTaple
        public void fillResidentJTaple(JTable table)
        {
            PreparedStatement ps ;
            ResultSet rs;
           String selectQuery = "SELECT * FROM `resident`";
          
                 try {
                     ps = my_Connection.CreateConnection().prepareStatement(selectQuery);
                     rs = ps.executeQuery();
                     
                     DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
                     
                     Object[]row;
                     while (rs.next()) 
                     {                         
                         row = new Object[5];
                         row[0] = rs.getInt(1);
                         row[1] = rs.getString(2);
                         row[2] = rs.getString(3);
                         row[3] = rs.getString(4);
                         row[4] = rs.getString(5);
                       
                     tableModel.addRow(row);
                     }
                 } 
                 catch (SQLException ex) {
                     Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
                 }
        }
}
