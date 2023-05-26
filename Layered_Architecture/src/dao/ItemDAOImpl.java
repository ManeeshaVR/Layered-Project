package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDTO;
import model.ItemDTO;
import view.tdm.ItemTM;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{
    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)";
        return SQLUtil.execute(sql, dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT code FROM Item WHERE code=?";
        ResultSet rs = SQLUtil.execute(sql, id);
        return rs.next();
    }

    @Override
    public String generate() throws SQLException, ClassNotFoundException {
        String sql = "SELECT code FROM Item ORDER BY code DESC LIMIT 1";
        ResultSet rst = SQLUtil.execute(sql);
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO search(String newValue) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Item WHERE code=?";
        ResultSet rst = SQLUtil.execute(sql, newValue);
        rst.next();
        ItemDTO item = new ItemDTO(newValue + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
        return item;
    }

    @Override
    public ObservableList<String> getIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> codes = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Item";
        ResultSet rst = SQLUtil.execute(sql);
        while (rst.next()) {
            codes.add(rst.getString(1));
        }
        return codes;
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        String sql = "SELECT * FROM Item";
        ResultSet rs = SQLUtil.execute(sql);
        while (rs.next()){
            ItemDTO itemDTO = new ItemDTO(rs.getString(1), rs.getString(2), rs.getBigDecimal(4), rs.getInt(3));
            allItems.add(itemDTO);
        }return allItems;
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        return SQLUtil.execute(sql, dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Item WHERE code=?";
        return SQLUtil.execute(sql, id);
    }
}
