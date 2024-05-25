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
import javax.servlet.http.HttpSession;
import model.UserDAO;
import model.UserDTO;
import model.UserError;
import util.DataHandler;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String LOGIN = "login.jsp";
    private static final String AD = "AD";
    private static final String ADMIN_PAGE = "admin.jsp";
    private static final String US = "US";
    private static final String USER_PAGE = "user.jsp";
    private static final String ST = "ST";
    private static final String STAFF_PAGE = "staff.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String url = LOGIN;

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        System.out.println("At Post LoginController");
        System.out.println("Data: " + user + " " + pass);
        UserError userError;
        try {
            userError = new UserError();
            if (!DataHandler.isEmptyFieldV2(user, pass)) {
                System.out.println("....Checking user data....");
                UserDAO userDao = new UserDAO();
                UserDTO userDTO = userDao.checkLogin(user, pass);
                System.out.println("UserDTO: " + userDTO);
                String ms = "";
                if (userDTO != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", userDTO);
//                phan quyen o day ne
                    int roleID = userDTO.getRoleID();
                    System.out.println("RoleId: " + roleID);
                    switch (roleID) {
                        case 0: {
                            url = USER_PAGE;
                            break;
                        }
                        case 1: {
                            url = ADMIN_PAGE;
                            break;
                        }
                        case 2: {
                            url = STAFF_PAGE;
                            break;
                        }
                        default: {
                            request.setAttribute("ERROR", "Your role is not support!");
                            break;
                        }
                    }
                } else {
                    ms = "Invalid user or password!!!";
                    request.setAttribute("fail", ms);
                }
            } else {
                userError.setUserID("*Is Required");
                userError.setPassword("*Is Required");
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}