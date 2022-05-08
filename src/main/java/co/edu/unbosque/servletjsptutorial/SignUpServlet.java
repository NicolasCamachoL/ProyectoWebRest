package co.edu.unbosque.servletjsptutorial;

import java.io.File;
import java.io.IOException;

import co.edu.unbosque.servletjsptutorial.services.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "signup", value = "/signup")
public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		try {
			new UserService().createUser(username, password, role,
					getServletContext().getRealPath("") + File.separator);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("./index.html");
	}

	public void destroy() {
	}
}
