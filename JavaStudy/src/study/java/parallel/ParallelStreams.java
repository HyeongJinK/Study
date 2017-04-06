package study.java.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {
	public static long iterativeSum(long n) {
		List<Integer> stream = new ArrayList<Integer>();
		stream.add(1);
		stream.stream()
			.filter(s -> true)
			.parallel()
			.map( s -> s+1 );
		
		stream.parallelStream();
		
		
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    

    public static void test(long n) {
        Cal cal= new Cal();
        Cal cal2= new Cal();
        AtomicCal cal3 = new AtomicCal();
        
        LongStream.rangeClosed(1, n).forEach(cal::add);		//��������
        LongStream.rangeClosed(1, n).parallel().forEach(cal2::add); //���Ŀ���
        LongStream.rangeClosed(1, n).parallel().forEach(cal3::add); //���Ŀ���
        
        System.out.println("cal: "+ cal.total + " cal2: "+ cal2.total);
        System.out.println("cal3: "+ cal3.total);
    }

    public static class Cal {
        private long total = 0;	//�����Ǵ� ��

        public void add(long value) {
        	total += value;
        }
    }
    
    public static class AtomicCal {
    	//Atomic[Integer|Boolean|Long....] ���� �����忡�� ���� ī���͸� ������Ʈ �� �� �����忡 ������ ������� �Ͼ�� ���ش�.
    	private AtomicLong total = new AtomicLong(0L);
    	
    	public void add(long value) {
    		total.addAndGet(value);
    	}
    }
}
