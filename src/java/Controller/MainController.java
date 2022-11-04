package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    public static final String LOGIN = "LoginController";
    public static final String LOGOUT = "LogoutController";  
    
    public static final String SEARCH = "SearchController";
    public static final String SEARCH_2 = "SearchRequestController";
    public static final String BOOKING = "AddRequestController";
    public static final String REGISTER = "RegisterController";
    public static final String VERIFY_ACCOUNT = "VerifyAccountController";
    public static final String UPDATE_REQUEST = "EditRequestController";  
    public static final String HISTORY = "GetHistoryController";
    public static final String DELETE = "DeleteRequestController";
    
    public static final String EDIT_REQUEST = "editRequest.jsp";
    public static final String ADD_REQUEST = "bookingForm.jsp";  
    public static final String ERROR = "errorMain.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if ("Login".equals(action)) {
                url = LOGIN;
            } else if("Logout".equals(action)){
                url = LOGOUT;
            } else if ("Search".equals(action)) {
                url = SEARCH;
            } else if("Search Request".equals(action)){
                url = SEARCH_2;
            } else if("Request".equals(action)){
                url = ADD_REQUEST;
            } else if("Booking".equals(action)){
                url = BOOKING;
            } else if("Cancel".equals(action)){
                url = SEARCH;
            } else if("Edit".equals(action)){
                url = EDIT_REQUEST;
            } else if("Register".equals(action)){
                url = REGISTER;
            } else if("Verify".equals(action)){
                url = VERIFY_ACCOUNT;
            } else if("Approve".equals(action) || "Reject".equals(action)){
                url = UPDATE_REQUEST;
            } else if("History".equals(action)){
                url = HISTORY;
            } else if("Find".equals(action)){
                url = HISTORY;
            } else if("Delete".equals(action)){
                url = DELETE;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
