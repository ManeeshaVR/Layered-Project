package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    public boolean save(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    public boolean search(String id) throws SQLException, ClassNotFoundException;
    public String generate() throws SQLException, ClassNotFoundException;

    public CustomerDTO select(String newValue) throws SQLException, ClassNotFoundException;

    public ObservableList<String> getIds() throws SQLException, ClassNotFoundException;

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    public boolean update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;
}
