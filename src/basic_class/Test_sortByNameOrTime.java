package basic_class;

public class Test_sortByNameOrTime {

    public static void main(String[] args) {

        AddressBook group[] = {new AddressBook(1, "Jack", "13282820696", 1109, "今天天气晴朗")};
        SortedSeqList<AddressBook> listb = new SortedSeqList<AddressBook>(group);
        listb.insertByTime(new AddressBook(2, "Mike", "13235810193", 623, "你吃了吗"));
        listb.insertByTime(new AddressBook(3, "Lisa", "15757136780", 1212, "明日有暴雨"));
        System.out.println("按时间排序:");
        System.out.println("通讯录:" + listb.toString() + "共" + listb.size() + "条");

        SortedSeqList<AddressBook> listb2 = new SortedSeqList<AddressBook>(3);
        listb2.insertByName(new AddressBook(1, "Jack", "13282820696", 1109, "今天天气晴朗"));
        listb2.insertByName(new AddressBook(2, "Mike", "13235810193", 623, "你吃了吗"));
        listb2.insertByName(new AddressBook(3, "Lisa", "15757136780", 1212, "明日有暴雨"));
        System.out.println("按姓名排序:");
        System.out.println("通讯录:" + listb2.toString() + "共" + listb.size() + "条");

    }
}
