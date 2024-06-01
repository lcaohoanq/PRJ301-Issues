package controller;

import model.GoogleAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.EnvUtils;
import util.GoogleLogin;

@WebServlet(name = "GoogleLoginController", urlPatterns = { "/GoogleLoginController" })
public class GoogleLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        String error = request.getParameter("error");
        // neu nguoi dung huy uy quyen
        if (error != null) {
            response.sendRedirect("/LoginController");
            return;
        }
        GoogleLogin gg = new GoogleLogin();
        String accessToken = gg.getToken(code);
        System.out.println("access_token: " + accessToken);
        GoogleAccount acc = gg.getUserInfo(accessToken);
        System.out.println("Data user: " + acc);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redirectUrl = "https://accounts.google.com/o/oauth2/auth?scope=email profile openid&redirect_uri="
                + EnvUtils.get("GOOGLE_REDIRECT_URI") + "&response_type=code&client_id="
                + EnvUtils.get("GOOGLE_CLIENT_ID") + "&approval_prompt=force";
        response.sendRedirect(redirectUrl);
    }

}
