package basic_class;

public class Test_SortedSeqList {

	public static void main(String[] args) {

		AddressBook group[] = {new AddressBook(1, "小明", "13282820696"), new AddressBook(2, "小红", "13235810193")};
		SortedSeqList<AddressBook> listb = new SortedSeqList<AddressBook>(group);
		listb.insert(new AddressBook(3, "小李", "15757136780"));
		listb.insert(new AddressBook(3, "小李", "15757136780"));
		//listb.insert(new AddressBook("小李", "15757136780"));
		System.out.println("通讯录:" + listb.toString() + "共" + listb.size() + "条");
		int id = 3;
		AddressBook key = new AddressBook(3, "", "");
		System.out.println("id为\"" + id + "\"的人是:" + listb.get(listb.search2(key)).name);
		System.out.println("删除联系人" + listb.remove2(key));
		System.out.println("通讯录:" + listb.toString() + "共" + listb.size() + "条");
		
	}

}
