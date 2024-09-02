package net.javaguides.usersregister.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.usersregister.model.Usersregister;
import net.javaguides.usersregister.dao.UsersregisterDao; // Import the DAO class

/**
 * Servlet implementation class UsersregisterServlet
 */
public class UsersregisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsersregisterDao usersregisterdao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersregisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Usersregister.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_id = request.getParameter("user_id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Usersregister user = new Usersregister();
        Usersregister.setUser_id(user_id);
        Usersregister.setName(name);
        Usersregister.setEmail(email);
        Usersregister.setPassword(password);
        Usersregister.setRole(role);

        usersregisterdao.usersregister(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Usersregisterdetails.jsp");
        dispatcher.forward(request, response);
    }

    public UsersregisterDao getUsersregisterdao() {
        return usersregisterdao;
    }

    public void setUsersregisterdao(UsersregisterDao usersregisterdao) {
        this.usersregisterdao = usersregisterdao;
    }
}
