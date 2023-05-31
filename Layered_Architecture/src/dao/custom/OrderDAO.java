package dao.custom;

import dao.CrudDAO;
import db.DBConnection;
import entity.Order;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO extends CrudDAO<Order> {
    public String generate() throws SQLException, ClassNotFoundException;
    public boolean saveOrder(String orderId, LocalDate date, String customerId) throws SQLException, ClassNotFoundException;

    public boolean saveAndUpdate(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);
}
