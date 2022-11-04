package Controller;

import DAO.RequestDAO;
import DTO.RequestDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchRequestController extends HttpServlet {

    public static final String SUCCESS = "management.jsp";
    public static final String ERROR = "errorListRequest.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String search = request.getParameter("SearchByName");
            String status = request.getParameter("StatusByStatus");
            String indexPage = request.getParameter("index");
            if(indexPage == null){
                indexPage = "1";
            }
            if(search == null) {
                search = "";                
            }
            if(status == null){
                status = "";
            }
                       
            int index = Integer.parseInt(indexPage);
            RequestDAO dao = new RequestDAO();
            List<RequestDTO> list = dao.getRequestList(search, status, index);
            if(list != null){
                int count = dao.getTotalRequestBySearch(search, status);
                int endRequestPage = count/5;
                if(count % 5 != 0){
                    endRequestPage++;
                }
                request.setAttribute("INDEX", index);
                request.setAttribute("END_PAGE", endRequestPage);
                request.setAttribute("LIST_REQUEST", list);
                url = SUCCESS;
            }else{
                url = SUCCESS;
            }
            
        } catch (Exception e) {
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
