package pack.repositories;

import org.springframework.data.repository.CrudRepository;
import pack.model.Contact;

import java.util.List;

/**
 * Created by Fresher on 27/06/2018.
 */
public interface ContactRepository extends CrudRepository<Contact, Integer>{


    Iterable<Contact> findAll();

    List<Contact> findByNameContaining(String s);

    void delete(Contact c);

    <T extends Contact>T save(T c);




}
