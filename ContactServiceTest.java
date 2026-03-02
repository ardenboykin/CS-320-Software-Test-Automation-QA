package contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the ContactService class
 * These tests verify that contacts can be added, deleted, and updated
 */
public class ContactServiceTest {
    // Tests that a contact can be added successfully
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345",
                "Mary",
                "Lamb",
                "1234567890",
                "123 Main Street"
        );

        assertDoesNotThrow(() -> service.addContact(contact));
    }

    @Test
    void testAddContactIDDuplicate() {
        // Tests that a duplicate contact ID will throw an error
        ContactService service = new ContactService();
        Contact contact1 = new Contact(
                "12345",
                "Mary",
                "Lamb",
                "1234567890",
                "123 Main Street"
        );
        Contact contact2 = new Contact(
                "12345",
                "Peter",
                "Pan",
                "0987654321",
                "456 Drury Lane"
        );

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    void testDeleteContact() {
        // Tests that a contact can be deleted successfully
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345",
                "Mary",
                "Lamb",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        assertDoesNotThrow(() -> service.deleteContact("12345"));
    }

    @Test
    void testDeleteNonexistentContact() {
        // Tests that attempting to delete a contact that doesn't exist will throw an error
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                service.deleteContact("DosentExist")
        );
    }

    @Test
    void testUpdateFirstName() {
        // Tests that a contact's first name can be changed
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345",
                "Mary",
                "Lamb",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updateFirstName("12345", "Little");

        assertEquals("Little", contact.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        // Tests that a contact's last name can be changed
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345",
                "Mary",
                "Lamb",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updateLastName("12345", "Poppins");

        assertEquals("Poppins", contact.getLastName());
    }

    @Test
    void testUpdatePhone() {
        // Tests that a contact's phone number can be changed
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345",
                "Mary",
                "Lamb",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updatePhone("12345", "0987654321");

        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void testUpdateAddress() {
        // Tests that a contact's address can be changed
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345",
                "Mary",
                "Lamb",
                "1234567890",
                "123 Main Street"
        );

        service.addContact(contact);
        service.updateAddress("12345", "456 Drury Lane");

        assertEquals("456 Drury Lane", contact.getAddress());
    }

    @Test
    void testUpdateNonexistentContact() {
        // Tests that attempting to update a contact that doesn't exist will throw an error
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName("DontExist", "FairyTale")
        );
    }
}