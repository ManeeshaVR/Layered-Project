package dao.custom;

import dao.CrudDAO;
import db.DBConnection;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {

}
