package controller;

import constant.EnumRole;
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
import util.PasswordHandler;

@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("At register controller");
        UserDAO dao = new UserDAO();
        UserError userError = new UserError();
        try {
            String userID = request.getParameter("userID");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String tickBox = request.getParameter("tickBox");

            System.out.println("Data register: " + userID + " " + name + " " + password + " " + confirm);

            if (!DataHandler.isEmtpyField(userID, name, password, confirm, tickBox)) {
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
                    UserDTO user = new UserDTO(userID, name, new PasswordHandler().hash(password.toCharArray()));
                    System.out.println("Data prepare to insert to db: " + user);
                    if (dao.insertV2(user, extractRoleFromID(userID) )) {
                        request.setAttribute("INSERT_SUCCESS", "Register successfully");
                    } else {
                        request.setAttribute("INSERT_ERROR", "Register fail");
                    }
                } else {
                    request.setAttribute("USER_ERROR", userError);
                }
            } else {
                userError.setUserID("*Is Required");
                userError.setName("*Is Required");
                userError.setPassword("*Is Required");
                userError.setConfirm("*Is Required");
                userError.setTickBox("*Is Required");
                request.setAttribute("USER_ERROR", userError);
            }

        } catch (Exception e) {
            log("Error at CreateController: " + e.toString());
            if (e.toString().contains("duplicate")) {
                userError.setUserID("Trung id roi!");
                request.setAttribute("USER_ERROR", userError);
            }

        } finally {
            request.getRequestDispatcher("./register.jsp").forward(request, response);
        }
    }

    private int extractRoleFromID(String userID) {
        int role = -1;
        switch (userID.substring(0, 2)) {
            case "MN": {
                role = 1;
                break;
            }
            case "ST": {
                role = 2;
                break;
            }
            case "US": {
                role = 0;
                break;
            }
        }
        return role;
    }

}
