package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact (ID must be unique for each contact)
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact can't be null.");
        }

        String contactID = contact.getContactID();
        if (contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }

        contacts.put(contactID, contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactID);
    }

    // Contact update methods
    public void updateFirstName(String contactID, String firstName) {
        getContact(contactID).setFirstName(firstName);
    }

    public void updateLastName(String contactID, String lastName) {
        getContact(contactID).setLastName(lastName);
    }

    public void updatePhone(String contactID, String phone) {
        getContact(contactID).setPhone(phone);
    }

    public void updateAddress(String contactID, String address) {
        getContact(contactID).setAddress(address);
    }

    // Helper method
    private Contact getContact(String contactID) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        return contact;
    }
}
