package java8.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ListStudy {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		//���� �Ұ����� ����Ʈ �����
		List<String> constList = Collections.unmodifiableList(list);
		
		
		//java8 ���� �÷��� �ݺ����� 
		for(String str : list) {
			System.out.println(str);
		}
		
		//java8 �÷��� �ݺ� : forEach 
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String arg0) {
				System.out.println(arg0);
			}
		});
		
		//���ٽ��� ����ؼ� �ڵ� ���̱�
		list.forEach((str) -> System.out.println(str));
	}
}
