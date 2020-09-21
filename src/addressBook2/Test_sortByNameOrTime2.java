package addressBook2;


import basic_class.SortedSeqList;

public class Test_sortByNameOrTime2 {

    public static void main(String[] args) {
        AddressBook2 a1 = new AddressBook2(1, "Jack", "13282820696", 1109, "今天天气晴朗", null);
        AddressBook2 a2 = new AddressBook2(2, "Mike", "13235810193", 623, "你吃了吗", a1);
        AddressBook2 a3 = new AddressBook2(3, "Lisa", "15757136780", 1212, "明日有暴雨", a2);
        AddressBook2 group[] = {a1};
        SortedSeqList<AddressBook2> listb = new SortedSeqList<AddressBook2>(group);
        listb.insertByTime(a2);
        listb.insertByTime(a3);
        System.out.println("按时间排序:");
        System.out.println("通讯录:" + listb.toString() + "共" + listb.size() + "条");

        SortedSeqList<AddressBook2> listb2 = new SortedSeqList<AddressBook2>(3);
        listb2.insertByName(a1);
        listb2.insertByName(a2);
        listb2.insertByName(a3);
        System.out.println("按姓名排序:");
        System.out.println("通讯录:" + listb2.toString() + "共" + listb.size() + "条");

    }
}
