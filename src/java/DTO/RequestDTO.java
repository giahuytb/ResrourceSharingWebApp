
package DTO;

import java.sql.Date;


public class RequestDTO {
    int requestID;
    String resourceName;
    String categoryName;
    String requestStatus;
    String userName;
    Date bookingDate;

    public RequestDTO(int requestID, String resourceName, String categoryName, String requestStatus, String userName, Date bookingDate) {
        this.requestID = requestID;
        this.resourceName = resourceName;
        this.categoryName = categoryName;
        this.requestStatus = requestStatus;
        this.userName = userName;
        this.bookingDate = bookingDate;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

        
   
   
    
    
}
