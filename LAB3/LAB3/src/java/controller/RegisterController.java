package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserDAO;
import model.UserDTO;
import model.UserError;
import util.DataHandler;

/**
 *
 * @author hd
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private static final String ERROR = "register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        UserDAO dao = new UserDAO();
        UserError userError = new UserError();
        try {
            String userID = request.getParameter("userID");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");

            System.out.println("Data register: " + userID + " " + name + " " + password + " " + confirm);

            if (!DataHandler.isEmtpyField(userID, name, password, confirm)) {
                boolean checkValidation = true;

                boolean checkDuplicate = dao.checkDuplicate(userID);
                if (checkDuplicate) {
                    userError.setUserID("Duplicate userID!");
                    checkValidation = false;
                } else {
                    System.out.println(DataHandler.isMatchUserID(userID));
                    if (!DataHandler.isMatchUserID(userID)) {
                        userError.setUserID("User ID must from [2,50] character and follow with (AD|US) in front");
                        checkValidation = false;
                    }
                    if (!DataHandler.isNameInRange(name, 5, 50)) {
                        userError.setName("Name must [5,50]");
                        checkValidation = false;
                    }
                    if (!DataHandler.isMatchPasswordAndConfirmPassword(password, password)) {
                        userError.setConfirm("hai Password khong giong nhau");
                        checkValidation = false;
                    }
                }

                if (checkValidation) {
                    UserDTO user = new UserDTO(userID, name, password);
                    boolean checkInsert = dao.insertV2(user);
                    request.setAttribute("INSERT_SUCCESS", "Register successfully");
                } else {
                    request.setAttribute("USER_ERROR", userError);
                }
            } else {
                userError.setUserID("*Is Required");
                userError.setName("*Is Required");
                userError.setPassword("*Is Required");
                userError.setConfirm("*Is Required");
                request.setAttribute("USER_ERROR", userError);
            }

        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
            if (e.toString().contains("duplicate")) {
                userError.setUserID("Trung id roi!");
                request.setAttribute("USER_ERROR", userError);
            }

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
    
    public static void main(String[] args) {
        String userID = "USHoang123";
        System.out.println(DataHandler.isMatchUserID(userID));
    }

}
