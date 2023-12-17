package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

import java.time.LocalDate;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @ResponseStatus(HttpStatus.OK)
    ContactDTO Show(@PathVariable Long id) {
        var contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Not Found: " + id)));
        var contactDTO = toDTO(contact);
        return contactDTO;
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    ContactDTO create(@RequestBody ContactCreateDTO contactData) {
        var contact = toEntity(contactData);
        contactRepository.save(contact);
        var contactDTO = toDTO(contact);
        return contactDTO;
    }

    private ContactDTO toDTO(Contact contact) {
        var dto = new ContactDTO();
        dto.setId(contact.getId());
        dto.setFirstName(contact.getFirstName());
        dto.setLastName(contact.getLastName());
        dto.setPhone(contact.getPhone());
        dto.setCreatedAt(contact.getcreatedAt());
    }

    private Contact toEntity(ContactCreateDTO contactDto) {
        var contact = new Contact();
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setPhone(contactDto.getPhone());
        return contact;
    }

    // END
}
