package za.ac.rcarstens.assignment6_2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.rcarstens.assignment6_2.domain.Customer;
import za.ac.rcarstens.assignment6_2.model.AdminResources;
import za.ac.rcarstens.assignment6_2.model.CustomerResources;
import za.ac.rcarstens.assignment6_2.services.AdminServices;
import za.ac.rcarstens.assignment6_2.services.CustomerServices;

import java.util.List;

/**
 * Created by student on 2015/09/26.
 */
@RestController
@RequestMapping("/api/**")
public class LoginPage {
    @Autowired
    private AdminServices service2;

    @Autowired
    private CustomerServices service1;

    //-------------------Retrieve All Customers--------------------------------------------------------

    @RequestMapping(value = "/customers/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomers() {
        List<Customer> Customers = service1.getAllCustomers();
        if(Customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Customer>>(Customers, HttpStatus.OK);
    }


    //-------------------Retrieve Single Customer--------------------------------------------------------

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id " + id);
        Customer Customer = service1.findById(id);
        if (Customer == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
    }


    //-------------------Login for Admin--------------------------------------------------------

    @RequestMapping(value="/admin/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminResources> loginAdmin(@PathVariable("loginEmail") String loginEmail, @PathVariable("password") String password)
    {
        boolean admin = service2.findAdminByEmailandPassword(loginEmail, password);

        if(!admin)
        {
            return new ResponseEntity<AdminResources>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<AdminResources>(HttpStatus.OK);
    }


    //-------------------Login for Customer--------------------------------------------------------

    @RequestMapping(value="/customer/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResources> loginUser(@PathVariable("loginEmail") String loginEmail, @PathVariable("password") String password)
    {
        boolean cust = service1.findCustomerByEmailandPassword(loginEmail, password);

        if(!cust)
        {
            return new ResponseEntity<CustomerResources>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<CustomerResources>(HttpStatus.OK);
    }

}
