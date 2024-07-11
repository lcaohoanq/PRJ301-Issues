package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SumServlet", urlPatterns = "/SumServlet")
public class SumServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String data = request.getParameter("data");

        System.out.println("Action: " + action);
        System.out.println("Data: " + data);

        if (!data.isEmpty()) {
            int value = Integer.parseInt(data);

            if (value < 5) {
                request.setAttribute("errorData", "You must input an integer > 5");
            } else if (action == null) {
                request.setAttribute("errorOption", "You must choose an option");

            } else {
                int result;

                if (action.equals("odd")) {
                    result = cal("odd", 1, value);
                } else if (action.equals("even")) {
                    result = cal("even", 1, value);
                } else {
                    result = 0; // Handle default case
                }

                System.out.println("Res: " + result);

                request.setAttribute("result", String.valueOf(result));
            }

        } else {
            request.setAttribute("errorOption", "You must enter a value to calculate");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public int cal(String options, int start, int end) {
        int sum = 0;

        // Iterate through numbers from start to end based on options
        for (int i = start; i <= end; i++) {
            if (options.equals("odd") && i % 2 != 0) {
                sum += i;
            } else if (options.equals("even") && i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
