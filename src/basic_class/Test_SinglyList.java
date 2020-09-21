package basic_class;

public class Test_SinglyList {

	public static void main(String[] args) {

		AddressBook group[] = {new AddressBook(0,"小明", "13282820696")};
		SinglyList<AddressBook> listc = new SinglyList<AddressBook>(group);
		listc.insert(new AddressBook(1,"小李", "15757136780"));
		System.out.println("通讯录:" + listc.toString() + "共" + listc.size() + "条");
		String name = "小李";
		AddressBook key = new AddressBook(3,name, "0");
		System.out.println("\"" + name + "\"的电话是:" + (listc.search(key)).toString());
		System.out.println("删除" + name);
		listc.remove(1);
		System.out.println("通讯录:" + listc.toString() + "共" + listc.size() + "条");
		/*String a[] = {"0","1","2","3"};
		SinglyList<String> list2 = new SinglyList<String>(a);
		list2.reverse2(list2);
		//list.reverse2(list2);
		System.out.println(list2.toString());*/
	}

}
