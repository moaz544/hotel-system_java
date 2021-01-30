
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Reservation {
/*resident tabel: ALTER TABLE reservations ADD CONSTRAINT fk_resident_id FOREIGN KEY (resident_id) REFERENCES resident(id) ON DELETE CASCADE
    rooms :ALTER TABLE reservations ADD CONSTRAINT fk_room_number FOREIGN KEY (room_number) REFERENCES rooms(r_number) ON DELETE CASCADE
     between rooms and type: ALTER TABLE rooms ADD CONSTRAINT fk_type_number FOREIGN KEY (type) REFERENCES type(id) ON DELETE CASCADE  
    */
    My_Connection my_Connection =new My_Connection();
    Rooms room = new Rooms();
     //Create afunction to add anew reservation
      public boolean addResrvation(int resident_id, int room_number, String dateIn, String dateOut)
        {
            PreparedStatement st ;

            String addQuery = "INSERT INTO `reservations`(`resident_id`, `room_number`, `date_in`, `date_out`) VALUES(?, ?, ?, ?)";
            try {
                    st = my_Connection.CreateConnection().prepareStatement(addQuery);

                    st.setInt(1, resident_id);
                    st.setInt(2, room_number);
                    st.setString(3, dateIn);
                    st.setString(4, dateOut);
              if(room.isRoomReserved(room_number).endsWith("No"))
              {  
                  if(st.executeUpdate()> 0)
                 {    
                   room.setRoomToReserved(room_number, "yes");
                     return true;
                 }
                 else
                  {
                       return false;
                  }
              } else
                  {
                      JOptionPane.showMessageDialog(null, "This Room is Already Reserved ", "Room is Reserved", JOptionPane.WARNING_MESSAGE);
                       return false;
                  }
              
          }
            
          catch (SQLException ex) {
                Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
                return false;}
        }      
        
    
  //Function to Edit a Reservation
      public boolean editReservation(int reservation_id, int resident_id, int room_number, String dateIn, String dateOut)
      {
          PreparedStatement st ;
          String editQuery = "UPDATE `reservations` SET `resident_id`=?,`room_number`=?,`date_in`=?,`date_out`=? WHERE `id`=?";
          try {
                    st = my_Connection.CreateConnection().prepareStatement(editQuery);

                    st.setInt(1, resident_id);
                    st.setInt(2, room_number);
                    st.setString(3, dateIn);
                    st.setString(4, dateOut);
                    st.setInt(5, reservation_id);

                    return (st.executeUpdate()> 0);
               
             }  catch (SQLException ex) {
              Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
              return false;
             }
      }
      
        //Function to delet a reservation
      public boolean deletReservation(int reservation_id)
      {
          PreparedStatement st ;
          String deletQuery = "DELETE FROM `reservations` WHERE `id`=?";
          try {
                    st = my_Connection.CreateConnection().prepareStatement(deletQuery);

                    st.setInt(1, reservation_id);
                    
                    //we need toget the room number before deleting it
                      int room_number = getRoomNumberFromReservation(reservation_id);

                  if(st.executeUpdate()> 0)
                     {    
                       room.setRoomToReserved(room_number , "No");
                         return true;
                     }
                     else{
                            return false;
                         }
               
             }  catch (SQLException ex) {
              Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
              return false;
             }
      }

       //Create afunction to display all reservationss type inJTable
          public void fillReservationsJTaple(JTable table)
        {
            PreparedStatement ps ;
            ResultSet rs;
           String selectQuery = "SELECT * FROM `reservations`";
          
                 try {
                     ps = my_Connection.CreateConnection().prepareStatement(selectQuery);
                     rs = ps.executeQuery();
                     
                     DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
                     
                     Object[]row;
                     while (rs.next()) 
                     {                         
                         row = new Object[5];
                         row[0] = rs.getInt(1);
                         row[1] = rs.getInt(2);
                         row[2] = rs.getInt(3);
                         row[3] = rs.getString(4);
                         row[4] = rs.getString(5);
                       
                     tableModel.addRow(row);
                     }
                 } 
                 catch (SQLException ex) {
                     Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
                 }
        }
     //Create afunction to get the room number from aReservation
          public int getRoomNumberFromReservation(int reservationID)
          {
             PreparedStatement ps ;
            ResultSet rs;
           String selectQuery = "SELECT `room_number` FROM `reservations` WHERE `id`= ?";
          
            try {
                ps = my_Connection.CreateConnection().prepareStatement(selectQuery);
                
               ps.setInt(1, reservationID);
                
                rs = ps.executeQuery();
                if(rs.next())
                {
                   return rs.getInt(1);
                }else{
                    return 0;
                     }
            }
             catch (SQLException ex) {
                     Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
                     return 0;
                 }
          }
}
