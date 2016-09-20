package contact;

/**
 * Created by dshue1 on 9/19/16.
 */
public class Contact {
	private String firstname;

	private String lastname;

	public Contact(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFullName() {
		return firstname + " " + lastname;
	}

	@Override
	public int hashCode() {
		return this.firstname.hashCode() * 10000 + this.lastname.hashCode();
	}

	@Override
	public boolean equals(Object contact) {
		if (contact == null) return false;
		if (! (contact instanceof Contact)) return false;
		Contact object = (Contact) contact;
		return object.getFirstname().equals(this.getFirstname())
			&& object.getLastname().equals(this.getLastname());
	}
}
