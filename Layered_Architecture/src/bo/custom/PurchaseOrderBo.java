package bo.custom;

import javafx.collections.ObservableList;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBo extends SuperBO{
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException ;

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException ;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

    public String generateOrderID() throws SQLException, ClassNotFoundException ;

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;

    public ObservableList<String> getItemCodes() throws SQLException, ClassNotFoundException;

    public ObservableList<String> getCustomerIds() throws SQLException, ClassNotFoundException;
}
