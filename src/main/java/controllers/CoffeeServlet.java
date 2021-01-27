package controllers;

import daos.Coffees;
import daos.DaoFactory;
import model.Coffee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.CoffeeServlet", urlPatterns = "/coffee")
public class CoffeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getParameter("choice");
        String type = req.getParameter("type");
        double price = Double.parseDouble(req.getParameter("cost"));

        Coffee custom = new Coffee(input, type, price);
        List<Coffee> allCoffees = DaoFactory.getCoffeesDao().all();
        DaoFactory.getCoffeesDao().insert(custom);

        req.setAttribute("coffeeList", allCoffees);
        req.getRequestDispatcher("/WEB-INF/coffees.jsp").forward(req, resp);
    }
}
