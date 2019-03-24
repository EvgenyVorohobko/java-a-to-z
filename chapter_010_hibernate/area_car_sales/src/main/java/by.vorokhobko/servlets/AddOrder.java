package by.vorokhobko.servlets;

import by.vorokhobko.database.CarDatabase;
import by.vorokhobko.database.OrderDatabase;
import by.vorokhobko.models.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

public class AddOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();

        Car car = new Car();
        car.setBody(new Body(Integer.valueOf(req.getParameter("idBody"))));
        car.setBrand(new Brand(Integer.valueOf(req.getParameter("idBrand"))));
        car.setColor(req.getParameter("color"));
        car.setDrive(new Drive(Integer.valueOf(req.getParameter("isDrive"))));
        car.setEngineSize(new Engine(Integer.valueOf(req.getParameter("idEngine"))));
        car.setFuel(new Fuel(Integer.valueOf(req.getParameter("idFuel"))));
        car.setMileage(Integer.valueOf("mileage"));
        car.setModel(new Model(Integer.valueOf(req.getParameter("idModel"))));
        car.setTransmission(new Transmission(Integer.valueOf(req.getParameter("idTransmission"))));
        car.setYear(new Year(Integer.valueOf(req.getParameter("idYear"))));
        CarDatabase.getINSTANCE().save(car);

        Order order = new Order();
        order.setCar(car);
        order.setCreateDate(new Timestamp(System.currentTimeMillis()));
        order.setDescription(req.getParameter("description"));
        order.setLocation(new Location(Integer.valueOf(req.getParameter("idLocation"))));
        order.setOwner((Owner) session.getAttribute("user"));
        order.setPrice(new Price(Integer.valueOf(req.getParameter("idPrice"))));
        order.setSold(false);
        OrderDatabase.getINSTANCE().save(order);
    }
}