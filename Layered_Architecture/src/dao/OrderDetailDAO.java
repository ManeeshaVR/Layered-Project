package dao;

import db.DBConnection;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface OrderDetailDAO {
    public boolean save(OrderDetailDTO detail, String orderId) throws SQLException, ClassNotFoundException;
}
