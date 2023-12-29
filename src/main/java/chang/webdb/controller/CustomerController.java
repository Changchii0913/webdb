package chang.webdb.controller;

import chang.webdb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import chang.webdb.model.Customer;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/customers")
    public String showCustomers(Model model) {
        // CustomerService 要資料
        List<Customer> custs = customerService.getCustomerAll();
        // 放入 model
        model.addAttribute("custs", custs);
        return "customer_list";
    }
    @GetMapping("/customers/register")
    public String toCustomers_Register(){
        return "customer_create";
    }
    @GetMapping("/customer/new")
    public  String Customers_Result(){
        return "customer_reg_result";
    }

}
