package basic_class;

import java.util.UUID;

public class AddressBook extends Object implements Comparable2<AddressBook> {
	int id;
	String name;
	String phoneNumber;
	int recentCall;
	String messageManage;
	AddressBook addressBook;
	
	public AddressBook(int id, String name, String phoneNumber, int recentCall, String messageManage) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.recentCall = recentCall;
		this.messageManage = messageManage;
	}

	public AddressBook(int id, String name, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.recentCall = 0;
		this.messageManage = "无";
	}
	
	public String toString() {
		return "(" + name + "," + phoneNumber +  "," + (recentCall / 100) + "月" + recentCall % 100 + "日" + "," + messageManage + ")";
	}
	
	public boolean equals(Object obj) {
		return this == obj || (obj instanceof AddressBook) && this.name.equals(((AddressBook)obj).name);
	}


	@Override
	public int compareToByTime(AddressBook obj) {
		return this.recentCall - obj.recentCall;
	}

	@Override
	public int compareToByName(AddressBook obj) {
		return this.name.compareTo(obj.name);
	}
	
	/*@Override
	public int compareTo(AddressBook obj) {
		for(int i=0;i<this.phoneNumber.length() && i<obj.phoneNumber.length();i++) {
			if(this.phoneNumber[i]!=obj.phoneNumber[i]) {
				return this.phoneNumber[i]-obj.phoneNumber[i];
			}
			return this.phoneNumber.length()-obj.phoneNumber.length();
		}
	}*/
}


