package builder;

public class BankAccount {
	private String name;
	private String accountNumber;
	private String address;
	private String email;
	private boolean mobileNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(boolean mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public BankAccount(BankAccountBuilder builder) {
		super();
		this.name = builder.name;
		this.accountNumber = builder.accountNumber;
		this.address = builder.address;
		this.email = builder.email;
		this.mobileNumber = builder.mobileNumber;
	}
	public static class BankAccountBuilder {
		private String name;//required
		private String accountNumber;//required
		private String address;
		private String email;
		private boolean mobileNumber;
		public BankAccountBuilder(String name, String accountNumber) {
			super();
			this.name = name;
			this.accountNumber = accountNumber;
		}
		public BankAccountBuilder withAddress(String address) {
			this.address = address;
			return this;
		}
		public BankAccountBuilder withEmail(String email) {
			this.email = email;
			return this;
		}
		public BankAccountBuilder withMobileNumber(boolean mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}
		public BankAccount build() {
			return new BankAccount(this);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public boolean isMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(boolean mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
	}
	@Override
	public String toString() {
		return "BankAccount [name=" + name + ", accountNumber=" + accountNumber + ", address=" + address + ", email="
				+ email + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
