
package DAO;

import DTO.ResourceDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ResourceDAO {
    
    public List<ResourceDTO> getList(String name, String cateName, int date, int index) throws SQLException {
        List<ResourceDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT id, B.categoryID, resourceName, color, B.categoryName, usingDate "
                        + " FROM tblResources A JOIN tblCategories B ON A.categoryID = B.categoryID"  
	                +"  Where resourceName like ? AND categoryName like ? AND usingDate > ? "
                        + " ORDER BY id OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                stm.setString(2, "%"+ cateName +"%");
                stm.setInt(3, date);
                stm.setInt(4, (index-1)*5 );
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String cateID = rs.getString("categoryID");
                    String resourceName = rs.getString("resourceName");
                    String color = rs.getString("color");
                    String categoryName = rs.getString("categoryName");
                    int usingDate = rs.getInt("usingDate");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(new ResourceDTO(id, resourceName, color, cateID, categoryName, usingDate));
                }
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
        return list;
    }
    
    public int getTotalResource(String search, String cateName, int usingDate) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT count(*) FROM tblResources A JOIN tblCategories B "
                    + " ON A.categoryID = B.categoryID  "
                    + " Where resourceName like ? AND categoryName like ? AND usingDate > ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + search +"%");
            stm.setString(2,"%" + cateName +"%" );
            stm.setInt(3, usingDate);
            rs = stm.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            } 
        } catch (Exception e) {
        }if (rs != null) {
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
