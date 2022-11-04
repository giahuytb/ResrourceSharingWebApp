package Controller;

import DAO.UserDAO;
import DTO.UserDTO;
import Gmail.SendGmail;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VerifyGmailController extends HttpServlet {
    
    public static final String ERROR = "ErrorVerifyMail.jsp";
    public static final String SUCCESS = "verifyMail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
            try {
                String userID = request.getParameter("userID");
                String gmail = request.getParameter("gmail");
                //create instance object of the SendEmail Class
                SendGmail sm = new SendGmail();
                //get the 6-digit code
                String verifyCode = sm.getCodeRandom();
                //craete new user using all information
                UserDTO user = new UserDTO(userID, gmail, verifyCode);

                //call the send email method
                boolean test = sm.senGmail(user);

                //check if the email send successfully
                if (test) {
                    UserDAO dao = new UserDAO();
                    UserDTO userNew = (UserDTO) request.getAttribute("NEW_ACCOUNT");
                    dao.insert(userNew);
                    HttpSession session = request.getSession();
                    session.setAttribute("USER", user);
                    url = SUCCESS;                   
                } 
                
            } catch (Exception e) {
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
