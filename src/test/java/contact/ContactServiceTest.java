package contact;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by dshue1 on 9/19/16.
 */
public class ContactServiceTest {
	@Test
	public void test() {
		ContactService contactService = new ContactService();

		Contact[] contactArray = {
			new Contact("john", "edwards"),
			new Contact("mary", "smith"),
			new Contact("josh", "Arnes")
		};

		List<Contact> contacts = Arrays.asList(contactArray);

		contactService.addContacts(contacts);

		Collection<Contact> output1 = contactService.getAllContacts();

		assertTrue(contacts.containsAll(output1));

		assertTrue(output1.containsAll(contacts));

		List<Contact> expected = Arrays.asList(contactArray[0]);

		Collection<Contact> output2 = contactService.getContactsByName("john", "edwards");

		assertTrue(expected.containsAll(output2));

		assertTrue(output2.containsAll(expected));

		List<Contact> searchExpected = Arrays.asList(contactArray[0], contactArray[1]);

		Collection<Contact> output3 = contactService.search("john smith");

		assertTrue(searchExpected.containsAll(output3));

		assertTrue(output3.containsAll(searchExpected));
	}
}
