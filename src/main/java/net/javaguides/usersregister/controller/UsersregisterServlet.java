package net.javaguides.usersregister.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.usersregister.model.Usersregister;
import net.javaguides.usersregister.dao.UsersregisterDao;

public class UsersregisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsersregisterDao usersregisterdao;

    @Override
    public void init() {
        usersregisterdao = new UsersregisterDao(); // Initialize DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Usersregister.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Usersregister user = new Usersregister();
        user.setUser_id(user_id);  // Correct method call on instance
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

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
