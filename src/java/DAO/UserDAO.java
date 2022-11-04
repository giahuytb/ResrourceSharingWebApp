package DAO;

import DTO.UserDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public UserDTO checkLoginUser(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = " SELECT userID, phone, userName, address, roleID, createDate, gmail, status FROM tblUsers "
                        + " Where userID = ? and password = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String phone = rs.getString("phone");
                    String userName = rs.getString("userName");
                    String address = rs.getString("address");
                    String roleID = rs.getString("roleID");
                    String email = rs.getString("gmail");
                    Date createDate = rs.getDate("createDate");
                    String status = rs.getString("status");
                    user = new UserDTO(userID, "***", phone, userName, address, roleID, email, createDate, status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }
    
    public boolean insert(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tblUsers(userID, password, phone, userName, address, roleID, gmail, createDate, status)"
                        + " VALUES(?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getPassword());
                stm.setString(3, user.getPhone());
                stm.setString(4, user.getUserName());
                stm.setString(5, user.getAddress());
                stm.setString(6, user.getRoleID());
                stm.setString(7, user.getGmail());
                stm.setDate(8, user.getCreateDate());
                stm.setString(9, user.getStatus());
                check = stm.executeUpdate() > 0 ?true: false;                
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    
    public boolean updateStatusUSer(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUsers SET status = ?"
                        + " WHERE userID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "Active");
                stm.setString(2, userID);
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
}
