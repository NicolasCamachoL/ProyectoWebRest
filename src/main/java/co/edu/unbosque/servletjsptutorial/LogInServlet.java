package co.edu.unbosque.servletjsptutorial;

import java.io.*;
import java.util.List;
import java.util.Optional;

import co.edu.unbosque.servletjsptutorial.dtos.User;
import co.edu.unbosque.servletjsptutorial.services.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "login", value = "/login")
public class LogInServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello, ";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        List<User> users = new UserService().getUsers();

        User userFounded = users.stream()
                .filter(user -> username.equals(user.getUsername()) && username.equals(user.getUsername()))
                .findFirst()
                .orElse(null);

        if (userFounded != null) {
            request.setAttribute("role", userFounded.getRole());

            Cookie cookie = new Cookie("role", userFounded.getRole());
            cookie.setMaxAge(20);
            response.addCookie(cookie);

            RequestDispatcher dispatcher = request.getRequestDispatcher("./home.jsp");
            dispatcher.forward(request, response);

        } else {
            response.sendRedirect("./401.html");
        }
    }

    public void destroy() {
    }
}