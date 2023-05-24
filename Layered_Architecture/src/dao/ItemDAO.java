package dao;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    public boolean delete(String code) throws SQLException, ClassNotFoundException;

    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    public boolean exist(String code) throws SQLException, ClassNotFoundException;
    public String generate() throws SQLException, ClassNotFoundException;

    public ItemDTO search(String newItemCode) throws SQLException, ClassNotFoundException;

    public ObservableList<String> getCodes() throws SQLException, ClassNotFoundException;
}
