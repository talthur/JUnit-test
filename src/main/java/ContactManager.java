import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {

    Map<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();

    public void addNewContact(String firstName, String lastName, String phoneNumber){

        Contact contact = new Contact(firstName, lastName, phoneNumber);
        checkIfContactAlreadyExists(contact);
        validateContact(contact);
        contacts.put(generateKey(contact), contact);

    }

    public String generateKey(Contact contact){
        return String.format("%s-%s", contact.getFirstName(), contact.getLastName());
    }

    public void validateContact(Contact contact){

        contact.validateFirstName();
        contact.validateLastName();
        contact.validatePhoneNumber();

    }

    public void checkIfContactAlreadyExists(Contact contact){
        if (contacts.containsKey(generateKey(contact))){
            throw new RuntimeException("Contact already on database");
        }
    }
}
