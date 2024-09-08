package ru.kalimulin.ContactManager.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kalimulin.ContactManager.models.Contact;
import ru.kalimulin.ContactManager.services.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "contacts/index";
    }

    @GetMapping("/new")
    public String showNewContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contacts/new";
    }

    @PostMapping()
    public String create(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contacts/new";
        }
        contactService.save(contact);
        return "redirect:/contacts";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("contact", contactService.findById(id));
        return "contacts/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("contact", contactService.findById(id));
        return "contacts/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("contact") @Valid Contact contact, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "contacts/edit";

        contactService.update(id, contact);
        return "redirect:/contacts";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }

}
