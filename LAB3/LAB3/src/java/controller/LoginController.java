package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserDAO;
import model.UserDTO;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String LOGIN = "login.jsp";
    private static final String WELLCOME = "welcome.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN;

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        System.out.println("Data: " + user + " " + pass);
        try {

            UserDAO login = new UserDAO();
            UserDTO userDTO = login.checkLogin(user, pass);
            String ms = "";
            if (userDTO != null) {
                ms = "Welcome: " + userDTO.getName();
                request.setAttribute("success", ms);
                url = WELLCOME;
            } else {
                ms = "Invalid user or password!!!";
                request.setAttribute("fail", ms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
