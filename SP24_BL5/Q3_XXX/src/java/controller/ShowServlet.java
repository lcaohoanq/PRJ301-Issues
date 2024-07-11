package controller;

import dao.BoatDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String selectedItem = request.getParameter("item");

        System.out.println("Selected item: " + selectedItem);

        if (selectedItem != null) {
            BoatDAO bDAO = new BoatDAO();

            switch (selectedItem) {
                case "allDeparturePlaces":
                    request.setAttribute("allDepaturePlaces", bDAO.getAllDeparturePlaces());
                    break;
                default:
                    request.getRequestDispatcher("show.jsp").forward(request, response);
            }
            request.getRequestDispatcher("show.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("show.jsp").forward(request, response);
        }

    }

}
