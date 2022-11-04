package Controller;

import DAO.ResourceDAO;
import DTO.ResourceDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchController extends HttpServlet {

    public static final String SUCCESS = "resource.jsp";
    public static final String ERROR = "SearchResourceERROR.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String indexPage = request.getParameter("index");
            String resourceName = request.getParameter("rsNameSearch");
            String cateName = request.getParameter("cateNameSearch");
            String usingDate = request.getParameter("usingDateSearch");
            if (indexPage == null) {
                indexPage = "1";
            }
            if (resourceName == null) {
                resourceName = "";
            }
            if (cateName == null) {
                cateName = "";
            }
            if (usingDate == null || usingDate == "") {
                usingDate = "0";
            }
            if(cateName.equals("All")){
                cateName ="";
            }

            int index = Integer.parseInt(indexPage);
            int usingDateParse = Integer.parseInt(usingDate);

            ResourceDAO dao = new ResourceDAO();
            List<ResourceDTO> list = dao.getList(resourceName, cateName, usingDateParse, index);
            if (list != null) {
                int count = dao.getTotalResource(resourceName, cateName, usingDateParse);
                int endPage = count / 5;
                if (count % 5 != 0) {
                    endPage++;
                }
                request.setAttribute("INDEX", index);
                request.setAttribute("END_PAGE", endPage);
                request.setAttribute("LIST_RESOURCES", list);
                url = SUCCESS;
            }else{
                url = SUCCESS;
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
