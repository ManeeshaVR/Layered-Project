package bo.custom.impl;

import bo.ItemBo;
import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import javafx.collections.ObservableList;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    ItemDAO item = new ItemDAOImpl();


    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return item.save(dto);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return item.exist(code);
    }

    @Override
    public String generate() throws SQLException, ClassNotFoundException {
        return item.generate();
    }

    @Override
    public ItemDTO searchItem(String newValue) throws SQLException, ClassNotFoundException {
        return item.search(newValue);
    }

    @Override
    public ObservableList<String> getItemCodes() throws SQLException, ClassNotFoundException {
        return item.getIds();
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return item.getAll();
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return item.update(dto);
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return item.delete(code);
    }
}
