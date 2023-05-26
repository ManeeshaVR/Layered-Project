package dao.custom;

import dao.CrudDAO;
import db.DBConnection;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface OrderDetailDAO extends CrudDAO<OrderDetailDTO> {
    public boolean save(OrderDetailDTO detail, String orderId) throws SQLException, ClassNotFoundException;
}