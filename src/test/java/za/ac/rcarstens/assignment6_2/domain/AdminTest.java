package za.ac.rcarstens.assignment6_2.domain;

import org.junit.Assert;
import za.ac.rcarstens.assignment6_2.factory.AdminFactory;
import za.ac.rcarstens.assignment6_2.factory.FullNameFactory;
import za.ac.rcarstens.assignment6_2.factory.LoginFactory;

/**
 * Created by student on 2015/09/13.
 */
public class AdminTest {
    //@Test
    public void testCreate() throws Exception {
        Login LoginDeats = LoginFactory.createLogin("ryan@gmail.com", "student");
        FullName FullNameDeats = FullNameFactory.createFullName("Ryan", "Carstens");
        Admin admin = AdminFactory
                .createAdmin(LoginDeats, FullNameDeats);
        Assert.assertEquals("ryan@gmail.com", admin.getLoginDeats().getLoginEmail());
    }

    //@Test
    public void testUpdate() throws Exception {
        Login LoginDeats = LoginFactory.createLogin("ryan@gmail.com", "student");
        FullName FullNameDeats = FullNameFactory.createFullName("Ryan", "Carstens");
        Admin admin = AdminFactory
                .createAdmin(LoginDeats, FullNameDeats);
        Login LoginDeatsCopy = LoginFactory.createLogin("ryan@gmail.com", "student");
        FullName FullNameDeatsCopy = FullNameFactory.createFullName("Ryan", "Carsten");

        Admin adminCopy = new Admin.Builder(LoginDeatsCopy).copy(admin).FullNameDeats(FullNameDeatsCopy).build();
        Assert.assertEquals("ryan@gmail.com", admin.getLoginDeats().getLoginEmail());
        Assert.assertEquals("ryan@gmail.com", adminCopy.getLoginDeats().getLoginEmail());
        Assert.assertEquals("Carstens", admin.getFullNameDeats().getLastname());
        Assert.assertEquals("Carsten", adminCopy.getFullNameDeats().getLastname());

    }
}
