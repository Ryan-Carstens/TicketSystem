package za.ac.rcarstens.assignment6_2.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.rcarstens.assignment6_2.domain.Admin;

/**
 * Created by student on 2015/08/12.
 */
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
