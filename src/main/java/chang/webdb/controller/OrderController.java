package chang.webdb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import chang.webdb.service.OrderService;

@Controller
public class OrderController
{
    @Autowired
    OrderService orderService;
    @GetMapping("/order_all")
    public String getAll(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders_list";
    }

    @GetMapping("/order_by_customer")
    public String getByCustomer(Model model, HttpServletRequest request) {
        String cno = request.getParameter("cno");
        int cno2 = 0;
        if( cno != null ) {
            cno2 = Integer.parseInt(cno);
        }

        model.addAttribute("orders", orderService.getOrderByCustomerNumber(cno2));
        return "orders_list";

    }
    @GetMapping("/order_by_no")
    public String getByCustomer(Model model, @RequestParam int ono) {
        model.addAttribute("orders", orderService.getOrderById(ono));
        return "orders_list";

    }


    @GetMapping("/qc")
    public String toQuery() {
        return "Query_Customer";
    }
    @GetMapping("/qono")
    public String QueryByOrderno() {
        return "Query_Orderno";
    }

}
