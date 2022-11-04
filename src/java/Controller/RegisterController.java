
package Controller;

import DTO.UserDTO;
import DTO.UserErrorDTO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterController extends HttpServlet {

    public static final String SUCCESS = "VerifyGmailController";
    public static final String ERROR = "register.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserErrorDTO userError = new UserErrorDTO("", "", "", "", "", "", "");
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String phone = request.getParameter("phone");
            String userName = request.getParameter("userName");
            String address = request.getParameter("address");
            String gmail = request.getParameter("gmail");
            long millis = System.currentTimeMillis();
            Date date = new java.sql.Date(millis); 
            
            boolean flag = true;
            
            if (userID.length() <= 5 || userID.length() > 50) {
                flag = false;
                userError.setUserIDError("User Id must must be [5-50]");
            }
            if (password.length() < 3 || password.length() > 50 ) {
                flag = false;
                userError.setPasswordError("password must be [3-50]");
            }
            if (!password.equals(confirm)) {
                flag = false;
                userError.setConfirmError("password and confirm must be the same");
            }           
            if (phone.length() != 10 ) {
                flag = false;
                userError.setPhoneError("Phone must be 10 number");
            }
            if (userName.length() > 30 || userName.length() < 5) {
                flag = false;
                userError.setUserNameError("User Name must be [1-30]");
            }
            if (address.length() > 70 || address.length() < 5) {
                flag = false;
                userError.setAddressError("User Name must be [5-30]");
            }            
            if (!gmail.matches("^[a-zA-Z_0-9](\\.?[a-zA-Z_0-9]){5,}@g(oogle)?mail\\.com$") ) {
                flag = false;
                userError.setGmailError("Gmail must like  ________@gamil.com");
            }             
            if (flag) {                
                UserDTO user = new UserDTO(userID, password, phone, userName, address,"Emp", gmail, date, "New");
                request.setAttribute("NEW_ACCOUNT", user);
                url = SUCCESS;             
            } 
            else {
                request.setAttribute("ERROR", userError);
            }
            
        } catch (Exception e) {
            log("ERROR at RegisterControler:" + e.toString());
            if (e.toString().contains("duplicate")) {
                userError.setUserIDError("This User ID has already existed !!!!");
                request.setAttribute("ERROR", userError);
            }
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
