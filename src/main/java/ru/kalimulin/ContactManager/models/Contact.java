package ru.kalimulin.ContactManager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 1, max = 128, message = "Имя должно содержать от 1 до 128 символов")
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$",
            message = "Номер телефона должен содержать от 10 до 15 символов и может начинаться с '+'")
    @Column(name = "phone_number")
    private String phoneNumber;

    public Contact() {

    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
