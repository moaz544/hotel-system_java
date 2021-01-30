
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Rooms {
        
    My_Connection my_Connection =new My_Connection();
    //Create afunction to display all rooms type inJTable
          public void fillRooms_Type_JTaple(JTable table)
        {
            PreparedStatement ps ;
            ResultSet rs;
           String selectQuery = "SELECT * FROM `type`";
          
                 try {
                     ps = my_Connection.CreateConnection().prepareStatement(selectQuery);
                     rs = ps.executeQuery();
                     
                     DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
                     
                     Object[]row;
                     while (rs.next()) 
                     {                         
                         row = new Object[3];
                         row[0] = rs.getInt(1);
                         row[1] = rs.getString(2);
                         row[2] = rs.getString(3);
                       
                     tableModel.addRow(row);
                     }
                 } 
                 catch (SQLException ex) {
                     Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
                 }
        }
          
              //Create afunction to display all rooms type inJTable
          public void fillRoomsTypeJTaple(JTable table)
        {
            PreparedStatement ps ;
            ResultSet rs;
           String selectQuery = "SELECT * FROM `rooms`";
          
                 try {
                     ps = my_Connection.CreateConnection().prepareStatement(selectQuery);
                     rs = ps.executeQuery();
                     
                     DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
                     
                     Object[]row;
                     while (rs.next()) 
                     {                         
                         row = new Object[4];
                         row[0] = rs.getInt(1);
                         row[1] = rs.getInt(2);
                         row[2] = rs.getString(3);
                         row[3] = rs.getString(4);
                       
                     tableModel.addRow(row);
                     }
                 } 
                 catch (SQLException ex) {
                     Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
                 }
        }
    
    //create afunction to fill th combobox whith rooms id
             public void fillRooms_Type_JComboBox(JComboBox comboBox)
        {
            PreparedStatement ps ;
            ResultSet rs;
           String selectQuery = "SELECT * FROM `type`";
          
                 try {
                     ps = my_Connection.CreateConnection().prepareStatement(selectQuery);
                     rs = ps.executeQuery();
                     
                     Object[]row;
                     while (rs.next()) 
                     { 
                     comboBox.addItem(rs.getInt(1));
                     }
                 } 
                 catch (SQLException ex) {
                     Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
                 }
        }
             
          //Create afunction to add anew room
             public boolean addRoom(int number, int type, String phone)
                {
                    PreparedStatement st ;

                    String addQuery = "INSERT INTO `rooms`(`r_number`, `type`, `phone`, `reserved`) VALUES (?,?,?,?)";
                    try {
                        st = my_Connection.CreateConnection().prepareStatement(addQuery);

                        st.setInt(1, number);
                        st.setInt(2, type);
                        st.setString(3, phone);
                    //Reserved: To tell us room is free or not.
                        st.setString(4, "No");
                     return (st.executeUpdate()> 0);


                    } catch (SQLException ex) {
                        Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }

                }
  //Function to Edit a Room
      public boolean editRoom(int number, int type, String phone, String isreserved)
      {
          PreparedStatement st ;
          String editQuery = "UPDATE `rooms` SET `type`=?,`phone`=?,`reserved`=? WHERE `r_number`=?";
          try {
                st = my_Connection.CreateConnection().prepareStatement(editQuery);

                st.setInt(1, type);
                st.setString(2, phone);
                st.setString(3, isreserved);
                st.setInt(4, number);

                return (st.executeUpdate()> 0);
               
             }  catch (SQLException ex) {
              Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
              return false;
             }
      }
      
        //Function to delet a room
      public boolean deletRoom(int roomnumber)
      {
        PreparedStatement st ;
        String deletQuery = "DELETE FROM `rooms` WHERE `r_number`=?";
        try {
                  st = my_Connection.CreateConnection().prepareStatement(deletQuery);

                  st.setInt(1, roomnumber);

                  return (st.executeUpdate()> 0);

           }  catch (SQLException ex) {
            Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
            return false;
           }
      }
      
      //creat afunction to refer to Room is Reserved or Not
      public boolean setRoomToReserved(int number, String isreserved)
      {
          PreparedStatement st ;
          String editQuery = "UPDATE `rooms` SET `reserved`=? WHERE `r_number`=?";
          try {
                    st = my_Connection.CreateConnection().prepareStatement(editQuery);

                    st.setString(1, isreserved);
                    st.setInt(2, number);

                    return (st.executeUpdate()> 0);
               
             }  catch (SQLException ex) {
              Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
              return false;
             }
      }
      //creat afunction to check if the room is already reserved
      public String isRoomReserved(int number)
      {
          PreparedStatement st ;
          ResultSet rs;
          String editQuery = "SELECT `reserved` FROM `rooms` WHERE `r_number` = ?";
          try {
                    st = my_Connection.CreateConnection().prepareStatement(editQuery);
                    st.setInt(1, number);
                    
                    rs = st.executeQuery();
                  if(rs.next())
                  {
                      return rs.getString(1);
                  }
                  else{
                         return "";
                  }
               
             }  catch (SQLException ex) {
              Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
              return " ";
             }
      }
      
      
}
