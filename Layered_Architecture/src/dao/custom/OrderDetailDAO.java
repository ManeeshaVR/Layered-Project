package dao.custom;

import dao.CrudDAO;
import db.DBConnection;
import entity.OrderDetail;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface OrderDetailDAO extends CrudDAO<OrderDetail> {
    public boolean save(OrderDetailDTO detail, String orderId) throws SQLException, ClassNotFoundException;
}
