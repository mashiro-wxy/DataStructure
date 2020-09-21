package addressBook2;

import basic_class.Comparable2;

public class AddressBook2 extends Object implements Comparable2<AddressBook2> {
    int id;
    String name;
    String phoneNumber;
    int recentCall;
    String messageManage;
    AddressBook2 addressBook;

    public AddressBook2(int id, String name, String phoneNumber, int recentCall, String messageManage, AddressBook2 addressBook2) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.recentCall = recentCall;
        this.messageManage = messageManage;
        addressBook = addressBook2;
    }

    public AddressBook2(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.recentCall = 0;
        this.messageManage = "无";
        addressBook = null;
    }

    public String toString() {
        if (addressBook != null) {
            return "(" + name + "," + phoneNumber + "," + "最近通话:" + addressBook.name + "打给" + name + " " + (recentCall / 100) + "月" + recentCall % 100 + "日"
                    + "," + "短信管理:" + addressBook.name + "发给" + name + " " + messageManage + ")";
        }
        else return "(" + name + "," + phoneNumber + "," + "最近通话:无"
                + "," + "短信管理:无";
    }

    public boolean equals(Object obj) {
        return this == obj || (obj instanceof AddressBook2) && this.name.equals(((AddressBook2)obj).name);
    }


    @Override
    public int compareToByTime(AddressBook2 obj) {
        return this.recentCall - obj.recentCall;
    }

    @Override
    public int compareToByName(AddressBook2 obj) {
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



