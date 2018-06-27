package pack.services;

import pack.model.Contact;

import java.util.List;

/**
 * Created by Fresher on 27/06/2018.
 */
public interface ContactService {

    Iterable<Contact> findAll();

    List<Contact> search(String name);

    Contact findOne(int id);

    void save(Contact c);

    void delete(int id);
}
