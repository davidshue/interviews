package contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dshue1 on 9/19/16.
 */
public class ContactService {
	private List<Contact> contacts = new ArrayList<>();

	public void addContacts( Collection<Contact> contacts ) {
		this.contacts.addAll(contacts);
	}

	public Collection<Contact> getAllContacts() {
		return contacts;
	}

	public Collection<Contact> getContactsByName( String firstName, String lastName ) {
		return contacts.stream().filter( (contact) ->
			contact.getFirstname().equalsIgnoreCase(firstName) &&
				contact.getLastname().equalsIgnoreCase(lastName)
		).collect(Collectors.toList());

	}

	public Collection<Contact> search( String searchInput ) {
		List<String> names = Arrays.asList(searchInput.split(" "));
		return contacts.stream().filter((contact) -> {
			return match(names, contact);
		}).collect(Collectors.toList());
	}

	private boolean match(List<String> names, Contact contact) {
		return names.stream().anyMatch( (name) -> contact.getFullName().contains(name));
	}
}
