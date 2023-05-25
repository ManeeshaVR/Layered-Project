package dao;

import javafx.collections.ObservableList;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T>{
    public boolean save(T dto) throws SQLException, ClassNotFoundException;

    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public String generate() throws SQLException, ClassNotFoundException;

    public T search(String newValue) throws SQLException, ClassNotFoundException;

    public ObservableList<String> getIds() throws SQLException, ClassNotFoundException;

    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    public boolean update(T dto) throws SQLException, ClassNotFoundException;

    public boolean delete(String id) throws SQLException, ClassNotFoundException;
}
