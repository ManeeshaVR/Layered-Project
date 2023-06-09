package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.OrderDetailDAO;
import entity.OrderDetail;
import javafx.collections.ObservableList;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(OrderDetailDTO detail, String orderId) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)";
        return SQLUtil.execute(sql, orderId, detail.getItemCode(), detail.getUnitPrice(), detail.getQty());
    }

//    @Override
//    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }

    @Override
    public boolean save(OrderDetail dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generate() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetail search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<String> getIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(OrderDetail dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
