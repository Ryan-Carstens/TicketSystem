package za.ac.rcarstens.assignment6_2.services;

import za.ac.rcarstens.assignment6_2.domain.Admin;

import java.util.List;

/**
 * Created by student on 2015/09/23.
 */
public interface AdminServices  {

    List<Admin> getAllAdmins();
    Admin findAdminByIDandEmail(Long id, String email);
    Admin save(Admin entity);
    Admin update(Admin entity);
    void delete(Admin entity);
    boolean exists(Long id);

}
