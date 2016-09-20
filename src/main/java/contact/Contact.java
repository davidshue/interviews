package contact;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
		return new HashCodeBuilder(17, 37)
			.append(firstname)
			.append(lastname)
			.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) { return false; }
		if (obj == this) { return true; }
		if (obj.getClass() != getClass()) {
			return false;
		}
		Contact contact = (Contact) obj;
		return new EqualsBuilder()
			.append(firstname, contact.firstname)
			.append(lastname, contact.lastname)
			.isEquals();
	}
}
