package dao.custom;

import dao.CrudDAO;
import db.DBConnection;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    public String generate() throws SQLException, ClassNotFoundException;
    public boolean save(String orderId, LocalDate date, String customerId) throws SQLException, ClassNotFoundException;

    public boolean saveAndUpdate(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);
}
