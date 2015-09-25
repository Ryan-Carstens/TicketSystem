package za.ac.rcarstens.assignment6_2.services;

import java.util.List;

/**
 * Created by hashcode on 2015/08/21.
 */
public interface Services<S, ID> {

    public S findById(ID id);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public List<S> findAll();
}