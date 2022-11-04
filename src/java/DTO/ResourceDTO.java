
package DTO;


public class ResourceDTO {
    int id;
    String resourceName;
    String color;
    String categoryID;
    String categoryName;
    int usingDate;

    public ResourceDTO() {
    }

    public ResourceDTO(int id, String resourceName, String color, String categoryID, String categoryName, int usingDate) {
        this.id = id;
        this.resourceName = resourceName;
        this.color = color;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.usingDate = usingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(int usingDate) {
        this.usingDate = usingDate;
    }

    
    
}
