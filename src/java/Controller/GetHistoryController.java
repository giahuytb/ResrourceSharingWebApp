
package Controller;

import DAO.RequestDAO;
import DTO.RequestDTO;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetHistoryController extends HttpServlet {

    public static final String SUCCESS = "historyRequest.jsp";
    public static final String ERROR = "errorHistory.jsp";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String resourceName = request.getParameter("rsNameSearch");
            String userName = request.getParameter("userName");
            String date = request.getParameter("dateSearch");
            String indexPage = request.getParameter("index");
            if(indexPage == null){
                indexPage = "1";
            }
            if(date == null ){
                date = "";
            }
            if(resourceName == null){
                resourceName = "";
            }
            int index = Integer.parseInt(indexPage);
            RequestDAO dao = new RequestDAO();
            List<RequestDTO> list = dao.getHistoryList(resourceName, userName, date, index);
            if(list != null){
                int count = dao.getTotalHistory(userName, resourceName, date);
                int endPage = count / 5;
                if (count %5 != 0) {
                    endPage++;
                }
                request.setAttribute("INDEX", index);
                request.setAttribute("END_PAGE", endPage);
                request.setAttribute("HISTORY_LIST", list);
                url = SUCCESS;
            }else{
                url = ERROR;
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
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
