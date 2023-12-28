package chang.webdb.controller;

import chang.webdb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import chang.webdb.model.Customer;
import chang.webdb.service.CustomerService;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/customers");
    public String showCustomers(Model model){
        List<Customer> custs=customerService.getCustomerAll();
        model.addAttribute("custs",custs);
        return "customer_list";
    }
}
