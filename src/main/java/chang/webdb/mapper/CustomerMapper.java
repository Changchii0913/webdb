package chang.webdb.mapper;

import org.springframework.jdbc.core.RowMapper;
import chang.webdb.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class    CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        // 因為 只有你知道你要那些欄位  或是 需要轉換資料的內容
        // ORM過程
        Customer c = new Customer();
       Customer customer = Customer();
       customer.setCustomerNumber(rs.getInt("customerNumber"));
       customer.setName(rs.getString("customerName"));
       customer.setPhone(rs.getString("phone"));
       customer.setCity(rs.getString("city"));
       customer.setCountry(rs.getString("country"));
       customer.setCreditLimit(rs.getDouble("creditLimit"));
        return customer;
    }
}
