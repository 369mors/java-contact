
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nec
 */
public class contactQuery {
    public boolean insertContact(contact cont) {
        boolean contactIsCreated = true;
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO mycontact(fname, lname, groupc, phone, email, address, pic, userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, cont.getFname());
            ps.setString(2, cont.getLname());
            ps.setString(3, cont.getLname());
            ps.setString(4, cont.getPhone());
            ps.setString(5, cont.getEmail());
            ps.setString(6, cont.getAddress());
            ps.setBytes(7, cont.getPic());
            ps.setInt(8, cont.getUid());
            
            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "New Contact Added");
                contactIsCreated = true;
            } else {
                JOptionPane.showMessageDialog(null, "Something went wrong");
                contactIsCreated = false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contactIsCreated;
    }
}
