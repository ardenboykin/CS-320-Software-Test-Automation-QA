package contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the Contact class
 * These tests verify that all the fields in the contact object meet requirements
 */
public class ContactTest {
    // Tests that a contact object can be successfully created
    @Test
    void testValidContactObject() {
        Contact contact = new Contact(
                "12345",
                "Mary",
                "Lamb",
                "1234567890",
                "123 Main Street"
        );

        assertEquals("12345", contact.getContactID());
        assertEquals("Mary", contact.getFirstName());
        assertEquals("Lamb", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactIDIsTooLong() {
        // Tests that an ID that is too long will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "12345678910",
                        "Mary",
                        "Lamb",
                        "1234567890",
                        "123 Main Street"
                )
        );
    }

    @Test
    void testContactIDIsNull() {
        // Tests that an ID that is null will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        null,
                        "Mary",
                        "Lamb",
                        "1234567890",
                        "123 Main Street"
                )
        );
    }

    @Test
    void testFirstNameIsTooLong() {
        // Tests that a first name that is too long will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "12345",
                        "ExtremelyLongFirstName",
                        "Lamb",
                        "1234567890",
                        "123 Main Street"
                )
        );
    }

    @Test
    void testFirstNameIsNull() {
        // Tests that a first name that is null will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "12345",
                        null,
                        "Lamb",
                        "1234567890",
                        "123 Main Street"
                )
        );
    }

    @Test
    void testLastNameIsTooLong() {
        // Tests that a last name that is too long will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "12345",
                        "Mary",
                        "ExtremelyLongLastName",
                        "1234567890",
                        "123 Main Street"
                )
        );
    }

    @Test
    void testLastNameIsNull() {
        // Tests that a last name that is null will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "12345",
                        "Mary",
                        null,
                        "1234567890",
                        "123 Main Street"
                )
        );
    }

    @Test
    void testPhoneIsNotTenDigits() {
        // Tests that a phon number that isn't ten digits exactly will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "12345",
                        "Mary",
                        "Lamb",
                        "12345",
                        "123 Main Street"
                )
        );
    }

    @Test
    void testPhoneIsNull() {
        // Tests that a phone number that is null will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "12345",
                        "Mary",
                        "Lamb",
                         null,
                        "123 Main Street"
                )
        );
    }

    @Test
    void testAddressIsTooLong() {
        // Tests that an address that is too long will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "12345",
                        "Mary",
                        "Lamb",
                        "1234567890",
                        "123 Main Street But It Is Even Longer Than The Actual Main Street Address Should Ever Be"
                )
        );
    }

    @Test
    void testAddressIsNull() {
        // Tests that an address that is null will throw an error
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "12345",
                        "Mary",
                        "Lamb",
                        "1234567890",
                        null
                )
        );
    }
}