package za.ac.rcarstens.assignment6_2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.rcarstens.assignment6_2.domain.Admin;
import za.ac.rcarstens.assignment6_2.domain.Customer;
import za.ac.rcarstens.assignment6_2.services.AdminServices;
import za.ac.rcarstens.assignment6_2.services.CustomerServices;

/**
 * Created by student on 2015/09/26.
 */
@RestController
@RequestMapping("/api/**")
public class SignUpPage {

    @Autowired
    private CustomerServices service1;

    @Autowired
    private AdminServices service2;

    //-------------------Create a Customer--------------------------------------------------------

    @RequestMapping(value = "/customer/signup", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
        System.out.println("Creating Customer " + customer.getFullNameDeats().getFirstname());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (service1.exists(customer.getID())) {
//            System.out.println("A Subject with name " + customer.getFullNameDeats().getFirstname() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service1.save(customer);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //-------------------Create a Admin--------------------------------------------------------

    @RequestMapping(value = "/admin/signup", method = RequestMethod.POST)
    public ResponseEntity<Void> createAdmin(@RequestBody Admin admin, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating admin " + admin.getFullNameDeats().getFirstname());
        if(service2.exists(admin.getID()))
        {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//        if (service1.exists(admin.getID())) {
//            System.out.println("A Subject with name " + admin.getFullNameDeats().getFirstname() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service2.save(admin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/admin/{id}").buildAndExpand(admin.getID()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
