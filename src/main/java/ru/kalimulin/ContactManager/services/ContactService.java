package ru.kalimulin.ContactManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kalimulin.ContactManager.models.Contact;
import ru.kalimulin.ContactManager.repositories.ContactsRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ContactService {
    private final ContactsRepository contactsRepository;

    @Autowired
    public ContactService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public List<Contact> findAll() {
        return contactsRepository.findAll();
    }

    public Contact findById(int id) {
        return contactsRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Contact contact) {
        contactsRepository.save(contact);
    }

    @Transactional
    public void update(int id, Contact updatedContact) {
        updatedContact.setId(id);
        contactsRepository.save(updatedContact);
    }

    @Transactional
    public void delete(int id) {
        contactsRepository.deleteById(id);
    }
}
