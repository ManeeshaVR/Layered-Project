package dao;

import db.DBConnection;
import model.ItemDTO;
import model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OrderDAOImpl implements OrderDAO{
    CrudDAO<ItemDTO> itemDAO = new ItemDAOImpl();
    OrderDetailDAO orderDAO = new OrderDetailDAOImpl();

    public String generate() throws SQLException, ClassNotFoundException {
        String sql = "SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1";
        ResultSet rst = SQLUtil.execute(sql);
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    public boolean saveAndUpdate(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        Connection connection = null;
        try {
            connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
            stm.setString(1, orderId);
            /*if order id already exist*/
            if (stm.executeQuery().next()) {

            }
            connection.setAutoCommit(false);

            boolean isSaved = save(orderId, orderDate, customerId);

            if (!isSaved) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }




            for (OrderDetailDTO detail : orderDetails) {
                boolean isSaved2 = orderDAO.save(detail, orderId);
                if (!isSaved2) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

//                //Search & Update Item
                ItemDTO item = itemDAO.search(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                boolean isUpdated = itemDAO.update(item);

                if (!isUpdated) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean save(String orderId, LocalDate date, String customerId) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)";
        return SQLUtil.execute(sql, orderId, Date.valueOf(date), customerId);
    }
}
