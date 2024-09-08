package ru.kalimulin.ContactManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kalimulin.ContactManager.models.Contact;

public interface ContactsRepository  extends JpaRepository<Contact, Integer> {

}
