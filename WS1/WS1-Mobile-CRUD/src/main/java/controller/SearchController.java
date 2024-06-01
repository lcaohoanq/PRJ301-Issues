package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserDAO;
import model.UserDTO;

@WebServlet(name = "SearchController", urlPatterns = { "/SearchController" })
public class SearchController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String search= request.getParameter("search");
            UserDAO dao= new UserDAO();
            List<UserDTO> listUser= dao.getListUser(search);
            if(listUser.size()>0){
                request.setAttribute("LIST_USER", listUser);
            }

        } catch (Exception e) {
            log("Error at SearchController:"+ e.toString());
        }finally{
            request.getRequestDispatcher("./admin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
