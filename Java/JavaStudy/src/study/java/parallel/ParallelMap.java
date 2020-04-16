package study.java.parallel;

import java.util.concurrent.ConcurrentHashMap;

public class ParallelMap {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> hm = new ConcurrentHashMap<>();
		
		hm.put("1", "a");
		hm.put("2", "b");
		hm.put("3", "c");
		hm.put("4", "d");
		
		hm.forEach((a,b)->{System.out.println("a: "+a+ " b: "+b);});	//BiConsumer  Ű, ��
		
		System.out.println(hm.compute("2", (a, b)-> b + "fkasdjf"));	//BiFunction  �ش��ϴ� Ű���� ã�Ƽ� �����Ѵ�.
	}
}
