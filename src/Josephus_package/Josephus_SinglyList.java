package Josephus_package;

import java.util.Random;
import basic_class.SinglyList;

public class Josephus_SinglyList {
	public Josephus_SinglyList(int number) {
		int start = 0;
		int distance = 0;
		System.out.print("Josephus(" + number + "),");
		SinglyList<String> list = new SinglyList<String>();
		for(int i=0;i<number;i++) {
			list.insert((char)('A'+i)+"");
		}
		System.out.println(list.toString());
		long t = System.currentTimeMillis();
		Random rd = new Random(t);
		start = rd.nextInt(list.size());
		int i = start;
		while(list.size()>1) {
			distance = rd.nextInt(list.size());
			i = distance % list.size();
			System.out.print("删除" + list.remove(i).toString() +",");
			System.out.println(list.toString());
			
		}
		System.out.println("被赦免者是" + list.get(0).toString());
		
	}
	public static void main(String args[]) {
		new Josephus_SinglyList(7);
	}
}
