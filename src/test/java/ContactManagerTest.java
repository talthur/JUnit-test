import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    @Test
    @DisplayName("Should create a contact")
    public void shouldCreateContact(){
        ContactManager contactManager = new ContactManager();
        contactManager.addNewContact("Arthur", "Gomes", "0123456789");
        assertFalse(contactManager.contacts.isEmpty());
        assertEquals(1, contactManager.contacts.size());
    }

    @Test
    @DisplayName("Should throw Runtime Exception: Contact already exists")
    public void shouldThrowRuntimeExceptionContactAlreadyExists(){
        ContactManager contactManager = new ContactManager();
        contactManager.addNewContact("Arthur", "Gomes", "0123456789");
        Assertions.assertThrows(RuntimeException.class, ()-> contactManager.addNewContact("Arthur",
                "Gomes", "0123456789"));
    }

    @Test
    @DisplayName("Should throw Runtime Exception: Phone cant be blank")
    public void shouldThrowRuntimeExceptionPhoneCantBeBlank(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, ()-> contactManager.addNewContact("Arthur",
                "Gomes", ""));
    }

    @Test
    @DisplayName("Should throw Runtime Exception: First name cant be blank")
    public void shouldThrowRuntimeErrorNameCantBeBlank(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> contactManager.addNewContact
                ("", "Gomes", "012345678"));
    }

    @Test
    @DisplayName("Should throw Runtime Exception: Last name cant be blank")
    public void shouldThrowRuntimeErrorLastNameCantBeBlank(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> contactManager.addNewContact
                ("Arthur", "", "012345678"));
    }

    @Test
    @DisplayName("Should throw Runtime Exception: Phone must start with 0")
    public void shouldThrowRuntimeErrorPhoneMustStartWIthO(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> contactManager.addNewContact
                ("Arthur", "Gomes", "123456789"));
    }
}