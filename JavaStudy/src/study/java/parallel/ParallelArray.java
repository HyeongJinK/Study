package study.java.parallel;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class ParallelArray {
	public static void main(String[] args) {
		int[] value = {6,2,7,4,5};
		
		Arrays.parallelSort(value);
		
		for (int v : value) {
			System.out.print(v);
		}
		
		System.out.println("");
		
		Arrays.parallelSetAll(value, v -> v * 2);	//��� �ε����� �޾Ƽ� ����Ѵ�.
		
		for (int v : value) {
			System.out.print(v);
		}
		
		System.out.println("");
		
		Arrays.parallelPrefix(value, (v, j) -> v+j);	//v�� �ʱⰪ + �� �� ���� ��� ��
		//j�� �迭�� ��
		
		for (int v : value) {
			System.out.println(v);
		}
		
		
	}
}
