package chang.webdb.controller;

import chang.webdb.model.Orders_demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import chang.webdb.Data.DBProvider;
import chang.webdb.service.DBService;
import chang.webdb.service.CustomerService;

import java.sql.ResultSet;
import java.util.List;

@Controller
public class ReportController {
    // 自己產生物件 new DBProvider ??????????
    // 正確: 託管 交由 springboot 管理
    DBProvider dbProvider = new DBProvider();
    // 託管版本
    @Autowired
    DBService dbService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/test123")
    public String sayHello(Model model) {
        // 注意重點:  dbSevice 並無  new DBServer() 的過程  就單純 宣告 使用  但注意 有加上＠Autowired
        String name =  dbService.getOrdersAll();
        Long cusa = dbService.countByCountry("USA");
        Long cfr = dbService.countByCountry("france");
        model.addAttribute("name", name);
        model.addAttribute("USA", cusa);
        model.addAttribute("France", cfr);
        return "hello";
    }


    @GetMapping("/orders")
    public String getOrderList(Model model) {
        // 提供一個訂單總覽  點選其中一筆 在顯示 訂單明細
        ResultSet rs = null;
        List<Orders_demo> orders;
        String sql = """
                SELECT
                  orders.orderNumber,
                  orders.orderDate,
                  orders.requiredDate,
                  orders.comments,
                  customers.customerName 
                FROM
                 orders
                 JOIN
                 customers
                 ON orders.customerNumber = customers.customerNumber                                
                """;
        // 傳遞需求後 接收 直接轉出
        orders = dbProvider.getOrderData(sql);
        // 接收資料 放入 model
        model.addAttribute("orders", orders);
        return "orders_list";
    }



}