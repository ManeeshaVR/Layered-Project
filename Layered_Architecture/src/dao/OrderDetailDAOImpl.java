package dao;

import db.DBConnection;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO{
    public boolean save(OrderDetailDTO detail, String orderId) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)";
        return SQLUtil.execute(sql, orderId, detail.getItemCode(), detail.getUnitPrice(), detail.getQty());
    }
}
