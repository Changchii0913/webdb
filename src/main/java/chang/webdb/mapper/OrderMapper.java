package chang.webdb.mapper;

import chang.webdb.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs,int rowNum)throws SQLException{
        Order order = new Order();
        order.getOrderNumber(rs.getInt("orderNumber"));
        order.getOrderDate(rs.getDate("orderDate"));
        order.getRequiredDate(rs.getDate("requireDate"));
        order.getshippedDate(rs.getDate())
    }
}
