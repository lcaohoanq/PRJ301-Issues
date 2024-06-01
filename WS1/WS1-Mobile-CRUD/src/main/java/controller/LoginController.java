package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import util.GoogleLogin;
import model.GoogleAccount;
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
import util.PasswordHandler;

@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {

    private static final int US = 0;
    private static final int AD = 1;
    private static final int ST = 2;
    private static final String ADMIN_PAGE = "admin.jsp";
    private static final String LOGIN = "login.jsp";
    private static final String USER_PAGE = "UserController";
    private static final String STAFF_PAGE = "StaffController";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = LOGIN;

        String userID = request.getParameter("user");
        String pass = request.getParameter("pass");

        System.out.println("Data: " + userID + " " + pass);
        UserError userError;
        try {
            userError = new UserError();
            if (!DataHandler.isEmptyFieldV2(userID, pass)) {
                System.out.println("Password input: " + pass);
                System.out.println("Password indb: " + new UserDAO().getPassword(userID));

                System.out.println(new PasswordHandler().authenticate(pass.toCharArray(), new UserDAO().getPassword(userID)));

                if (new PasswordHandler().authenticate(pass.toCharArray(), new UserDAO().getPassword(userID))) {
                    UserDTO userDTO = new UserDAO().findUserById(userID);
                    String ms = "";
                    if (userDTO != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("LOGIN_USER", userDTO);
                        // phan quyen o day ne
                        System.out.println(userDTO.getRoleID());
                        int roleID = userDTO.getRoleID();
                        switch (roleID) {
                            case US: {
                                url = USER_PAGE;
                                break;
                            }
                            case AD: {
                                url = ADMIN_PAGE;
                                break;
                            }
                            case ST: {
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
                    userError.setPassword("Invalid Password");
                    request.setAttribute("USER_ERROR", userError);
                }
            } else {
                userError.setUserID("*Is Required");
                userError.setPassword("*Is Required");
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("URL = " + url);
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

}