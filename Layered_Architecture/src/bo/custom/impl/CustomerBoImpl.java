package bo.custom.impl;

import bo.custom.CustomerBo;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import entity.Customer;
import javafx.collections.ObservableList;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    CustomerDAO customer = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customer.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customer.exist(id);
    }

    @Override
    public String generate() throws SQLException, ClassNotFoundException {
        return customer.generate();
    }

    @Override
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException {
        Customer search = customer.search(newValue);
        return new CustomerDTO(search.getId(), search.getName(), search.getAddress());
    }

    @Override
    public ObservableList<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        return customer.getIds();
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customer.getAll();
        ArrayList<CustomerDTO> customers = new ArrayList<>();
        for (Customer customerEn : all){
            customers.add(new CustomerDTO(customerEn.getId(), customerEn.getName(), customerEn.getAddress()));
        }return customers;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customer.update(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customer.delete(id);
    }
}
