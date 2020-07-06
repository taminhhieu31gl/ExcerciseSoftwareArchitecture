package adapter3;

public class Customer {
	public static final String US = "US";
	public static final String CANADA = "Canada";
	private String address;
	private String name;
	private String zip, state, type;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isValidAddress() {
		// get an appropriate address validator
		AddressValidator validator = getValidator(type);
		// Polymorphic call to validate the address
		return validator.isValidAddress(address, zip, state);
	}

	private AddressValidator getValidator(String custType) {
		AddressValidator validator = null;
		if (custType.equals(Customer.US)) {
			validator = new USAddress();
		}
		if (type.equals(Customer.CANADA)) {
			validator = new CAAddressAdapter();
		}
		return validator;
	}

	public Customer(String inp_name, String inp_address, String inp_zip, String inp_state, String inp_type) {
		name = inp_name;
		address = inp_address;
		zip = inp_zip;
		state = inp_state;
		type = inp_type;
	}
}
