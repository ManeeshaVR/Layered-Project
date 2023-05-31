package bo.custom.impl;

import bo.custom.PurchaseOrderBo;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.OrderDAO;
import entity.Customer;
import entity.Item;
import javafx.collections.ObservableList;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBoImpl implements PurchaseOrderBo {
    CustomerDAO customer = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO item = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO order = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer customerEntity = customer.search(id);
        return new CustomerDTO(customerEntity.getId(), customerEntity.getName(), customerEntity.getAddress());
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        Item itemEntity = item.search(code);
        return new ItemDTO(itemEntity.getCode(), itemEntity.getDescription(), itemEntity.getUnitPrice(), itemEntity.getQtyOnHand());
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return item.exist(code);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customer.exist(id);
    }

    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        return order.generate();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customer.getAll();
        ArrayList<CustomerDTO> customers = new ArrayList<>();
        for (Customer customerEn : all){
            customers.add(new CustomerDTO(customerEn.getId(), customerEn.getName(), customerEn.getAddress()));
        }return customers;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = item.getAll();
        ArrayList<ItemDTO> items = new ArrayList<>();
        for (Item itemEn : all){
            items.add(new ItemDTO(itemEn.getCode(), itemEn.getDescription(), itemEn.getUnitPrice(), itemEn.getQtyOnHand()));
        }return items;
    }

    @Override
    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        return order.saveAndUpdate(orderId, orderDate, customerId, orderDetails);
    }

    @Override
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
        Item search = item.search(code);
        return new ItemDTO(search.getCode(), search.getDescription(), search.getUnitPrice(), search.getQtyOnHand());
    }

    @Override
    public ObservableList<String> getItemCodes() throws SQLException, ClassNotFoundException {
        return item.getIds();
    }

    @Override
    public ObservableList<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        return customer.getIds();
    }
}
