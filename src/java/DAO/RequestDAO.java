package DAO;

import DTO.RequestDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {

    public List<RequestDTO> getRequestList(String name, String status, int index) throws SQLException {
        List<RequestDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT requestID, C.resourceName, D.categoryName, requestStatus, userName, bookingDate "
                    + " FROM tblUsers A "
                    + " JOIN tblRequests B ON A.userID = B.userID "
                    + "	JOIN tblResources C ON B.resourceID = C.id "
                    + "	JOIN tblCategories D ON C.categoryID = D.categoryID "
                    + " Where resourceName like ? AND requestStatus like ? "
                    + " ORDER BY requestID OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");
            stm.setString(2, "%" + status + "%");
            stm.setInt(3, (index - 1) * 5);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("requestID");
                String resourseName = rs.getString("resourceName");
                String categoryName = rs.getString("categoryName");
                String requestStatus = rs.getString("requestStatus");
                String userID = rs.getString("userName");
                Date bookingDate = rs.getDate("bookingDate");
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new RequestDTO(id, resourseName, categoryName, requestStatus, userID, bookingDate));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
        return list;
    }

    public int getTotalRequest() throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "Select count(*) from tblRequests";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
        return -1;
    }

    public int getTotalRequestBySearch(String resourceName, String status) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT count(*) FROM tblResources A Join tblRequests B on A.id = B.resourceID "
                    + " WHERE resourceName like ? AND requestStatus like ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + resourceName + "%");
            stm.setString(2, "%" + status + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
        return -1;
    }

    public boolean addRequest(int id, int resourceID, String categoryID, String userID, Date booking) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT INTO tblRequests(requestID, resourceID, categoryID, requestStatus, userID, bookingDate)"
                        + " VALUES(?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                stm.setInt(2, resourceID);
                stm.setString(3, categoryID);
                stm.setString(4, "New");
                stm.setString(5, userID);
                stm.setDate(6, booking);
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public boolean updateRequestStatus(String status, int requestID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblRequests SET requestStatus = ? "
                        + " WHERE requestID = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, status);
                stm.setInt(2, requestID);
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

    public List<RequestDTO> getHistoryList(String name, String userName, String date, int index) throws SQLException {
        List<RequestDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT requestID, C.resourceName, D.categoryName, requestStatus, userName, bookingDate "
                    + " FROM tblUsers A "
                    + " JOIN tblRequests B ON A.userID = B.userID "
                    + " JOIN tblResources C ON B.resourceID = C.id "
                    + " JOIN tblCategories D ON C.categoryID = D.categoryID "
                    + " Where resourceName like ? AND requestStatus not like 'Delete' AND userName = ?"
                    + " AND bookingDate like ? "
                    + " ORDER BY bookingDate OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");
            stm.setString(2, userName);
            stm.setString(3, "%" + date + "%");
            stm.setInt(4, (index - 1) * 5);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("requestID");
                String resourseName = rs.getString("resourceName");
                String categoryName = rs.getString("categoryName");
                String requestStatus = rs.getString("requestStatus");
                String userID = rs.getString("userName");
                Date bookingDate = rs.getDate("bookingDate");
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(new RequestDTO(id, resourseName, categoryName, requestStatus, userID, bookingDate));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
        return list;
    }

    public int getTotalHistory(String userName, String resourceName, String bookingDate) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT count(*) FROM tblResources A Join tblRequests B on A.id = B.resourceID "
                    + "	join tblUsers C ON B.userID = C.userID "
                    + "	Where userName = ?  AND resourceName like ? AND bookingDate like ? AND requestStatus not like 'Delete'";
            stm = conn.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, "%" + resourceName + "%");
            stm.setString(3, "%" + bookingDate + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (conn != null) {
            conn.close();
        }
        return -1;
    }
    

}
