/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TrainBookServlet", urlPatterns = "/TrainBookServlet")
public class TrainBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String seat = request.getParameter("seat");
		String book = request.getParameter("book");

		System.out.println("Code: " + code);
		System.out.println("name: " + name);
		System.out.println("seat: " + seat);
		System.out.println("book: " + book);

		// seat < book => ko hien gi het
		if (!code.isEmpty() && !name.isEmpty() && !seat.isEmpty() && !book.isEmpty()) {
			int seatValue = Integer.parseInt(seat);
			int bookValue = Integer.parseInt(book);
			// seat > book => not full
			// seat = book => full

			if (bookValue > seatValue) {
				request.setAttribute("errorBookedGreaterThanSeat", "You must input booked <= seat");

			} else {
				if (bookValue == seatValue) {
					request.setAttribute("errorFull", "Full");
				} else if (seatValue > bookValue) {
					request.setAttribute("errorNotFull", "Not Full");
				}

				request.setAttribute("code", code);
				request.setAttribute("name", name);
				request.setAttribute("seat", seat);
				request.setAttribute("book", book);
			}
		} else {
			request.setAttribute("errorLackOfData", "Please provide all data");
		}

		request.getRequestDispatcher("MyExam.jsp").forward(request, response);

	}

}
