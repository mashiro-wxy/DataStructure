package basic_class;

public class Test_SeqList {

	public static void main(String[] args) {

		AddressBook group[] = {new AddressBook(1,"小明", "13282820696"), new AddressBook(2,"小红", "13235810193")};
		SeqList<AddressBook> lista = new SeqList<AddressBook>(group);
		lista.insert(new AddressBook(3,"小李", "15757136780"));
		System.out.println("通讯录:" + lista.toString() + "共" + lista.size() + "条");
		String name = "小李";
		AddressBook key = new AddressBook(4,name, "0");
		System.out.println("\"" + name + "\"的电话是:" + lista.search(key).phoneNumber);
		System.out.println("删除" + name);
		lista.remove(2);
		System.out.println("通讯录:" + lista.toString() + "共" + lista.size() + "条");
		
	}

}
