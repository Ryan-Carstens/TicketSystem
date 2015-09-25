package za.ac.rcarstens.assignment6_2.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.rcarstens.assignment6_2.domain.Admin;
import za.ac.rcarstens.assignment6_2.repository.AdminRepository;
import za.ac.rcarstens.assignment6_2.services.AdminServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/24.
 */
@Service
public class AdminImpl implements AdminServices {
    @Autowired
    AdminRepository repository;

    public List<Admin> getAllAdmins()
    {
        List<Admin> Admins = new ArrayList<Admin>();

        Iterable<Admin> admins = repository.findAll();
        for (Admin admin : admins) {
            Admins.add(admin);
        }
        return Admins;
    }

    public Admin findAdminByIDandEmail(Long id, String loginEmail)
    {
        Admin admin = repository.findOne(id);
        if(admin != null)
        {
            if(admin.getLoginDeats().getLoginEmail().equals(loginEmail))
                return admin;
        }

        return null;
    }

    public Admin save(Admin entity) {
        return repository.save(entity);
    }

    public Admin update(Admin entity) {
        return repository.save(entity);
    }

    public void delete(Admin entity) {
        repository.delete(entity);

    }

    public boolean exists(Long id)
    {
        if(repository.findOne(id)!= null)
            return true;

        return false;
    }
}
