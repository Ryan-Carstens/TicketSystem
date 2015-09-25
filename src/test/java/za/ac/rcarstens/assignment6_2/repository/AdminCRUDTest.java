package za.ac.rcarstens.assignment6_2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.rcarstens.assignment6_2.App;
import za.ac.rcarstens.assignment6_2.domain.Admin;
import za.ac.rcarstens.assignment6_2.domain.FullName;
import za.ac.rcarstens.assignment6_2.domain.Login;
import za.ac.rcarstens.assignment6_2.factory.AdminFactory;
import za.ac.rcarstens.assignment6_2.factory.FullNameFactory;
import za.ac.rcarstens.assignment6_2.factory.LoginFactory;

/**
 * Created by student on 2015/09/21.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AdminCRUDTest  extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    private AdminRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {


    }

    @Test
    public void create() throws Exception {
        Login LoginDeats = LoginFactory.createLogin("ryan@gmail.com", "student");
        FullName FullNameDeats = FullNameFactory.createFullName("Ryan", "Carstens");
        Admin admin = AdminFactory
                .createAdmin(LoginDeats, FullNameDeats);

        repository.save(admin);
        id=admin.getID();
        Assert.assertNotNull(admin.getID());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Admin admin = repository.findOne(id);
        org.junit.Assert.assertNotNull(admin);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Admin admin = repository.findOne(id);

        Login LoginDeatsCopy = LoginFactory.createLogin("ryan@gmail.com", "student");
        FullName FullNameDeatsCopy = FullNameFactory.createFullName("Ryan", "Carsten");

        Admin newAdmin = new Admin.Builder(LoginDeatsCopy).copy(admin).FullNameDeats(FullNameDeatsCopy).build();
        repository.save(newAdmin);

        Admin updatedAdmin = repository.findOne(id);
        Assert.assertEquals(updatedAdmin.getFullNameDeats().getLastname(), "Carsten");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Admin admin = repository.findOne(id);
        repository.delete(admin);
        Admin deletedAdmin = repository.findOne(id);
        Assert.assertNull(deletedAdmin);
    }
}
