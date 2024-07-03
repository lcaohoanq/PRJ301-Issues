package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import utils.DBUtils;

public class AppointmentDAO {

    public void addAppointment(int userId, String appointmentDate, String appointmentTime, String purpose) {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(
                    "INSERT INTO Appointments (userId, appointmentDate, appointmentTime, purpose, status) VALUES (?, ?, ?, ?, ?)");
                ptm.setInt(1, userId);
                ptm.setString(2, appointmentDate);
                ptm.setString(3, appointmentTime);
                ptm.setString(4, purpose);
                ptm.setString(5, "Scheduled");
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editAppointment(int id, String appointmentDate, String appointmentTime, String purpose) {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(
                    "UPDATE Appointments SET appointmentDate = ?, appointmentTime = ?, purpose = ? WHERE id = ?");
                ptm.setString(1, appointmentDate);
                ptm.setString(2, appointmentTime);
                ptm.setString(3, purpose);
                ptm.setInt(4, id);
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelAppointment(int id) {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(
                    "UPDATE Appointments SET status = 'Cancelled' WHERE id = ?");
                ptm.setInt(1, id);
                ptm.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AppointmentDAO().cancelAppointment(2);
    }

}
