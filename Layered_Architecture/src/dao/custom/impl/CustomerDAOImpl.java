package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.CustomerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Customer (id,name, address) VALUES (?,?,?)";
        return SQLUtil.execute(sql, dto.getId(), dto.getName(), dto.getAddress());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM Customer WHERE id=?";
        ResultSet resultSet = SQLUtil.execute(sql, id);
        return resultSet.next();
    }

    @Override
    public String generate() throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1";
        ResultSet rst = SQLUtil.execute(sql);
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM Customer WHERE id=?", newValue);
        resultSet.next();
        CustomerDTO customerDTO = new CustomerDTO(newValue + "", resultSet.getString("name"), resultSet.getString("address"));
        return customerDTO;
    }

    @Override
    public ObservableList<String> getIds() throws SQLException, ClassNotFoundException {
        ObservableList<String> ids = FXCollections.observableArrayList();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        while (rst.next()) {
            ids.add(rst.getString(1));
        }
        return ids;
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ResultSet rs = SQLUtil.execute("SELECT * FROM Customer");
        while (rs.next()){
            CustomerDTO customerDTO = new CustomerDTO(rs.getString(1), rs.getString(2), rs.getString(3));
            allCustomers.add(customerDTO);
        }return allCustomers;
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET name=?, address=? WHERE id=?";
        return SQLUtil.execute(sql, dto.getName(), dto.getAddress(), dto.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Customer WHERE id=?";
        return SQLUtil.execute(sql, id);
    }
//    @Override
//    public boolean save(CustomerDTO customer) throws SQLException, ClassNotFoundException {

//    }
//
//    @Override
//    public boolean exist(String id) throws SQLException, ClassNotFoundException {

//    }
//
//    @Override
//    public String generate() throws SQLException, ClassNotFoundException {

//    }
//
//    @Override
//    public CustomerDTO share(String newValue) throws SQLException, ClassNotFoundException {

//    }
//
//    @Override
//    public ObservableList<String> getIds() throws SQLException, ClassNotFoundException {

//    }
//
//    @Override
//    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {

//    }
//
//    @Override
  //  public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

//    }
//
//    @Override
//    public boolean delete(String id) throws SQLException, ClassNotFoundException {

//    }

}
