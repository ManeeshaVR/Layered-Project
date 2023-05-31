package bo.custom.impl;

import bo.custom.ItemBo;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import entity.Item;
import javafx.collections.ObservableList;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    ItemDAO item = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);


    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return item.save(new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
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
        Item search = item.search(newValue);
        return new ItemDTO(search.getCode(), search.getDescription(), search.getUnitPrice(), search.getQtyOnHand());
    }

    @Override
    public ObservableList<String> getItemCodes() throws SQLException, ClassNotFoundException {
        return item.getIds();
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
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return item.update(new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand()));
    }

    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return item.delete(code);
    }
}
