package pack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.model.Contact;
import pack.repositories.ContactRepository;

import java.util.List;

/**
 * Created by Fresher on 27/06/2018.
 */
@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> search(String name) {
        return contactRepository.findByNameContaining(name);
    }

    @Override
    public Contact findOne(int id) {
        return contactRepository.findOne(id);
    }

    @Override
    public void save(Contact c) {
        contactRepository.save(c);
    }

    @Override
    public void delete(int id) {
        contactRepository.delete(id);
    }


    public ContactRepository getContactRepository() {
        return contactRepository;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
