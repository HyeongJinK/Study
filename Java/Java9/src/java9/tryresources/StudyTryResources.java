package java9.tryresources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudyTryResources {
	public void java7before () {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void java7after() throws FileNotFoundException {
		// ���ҽ��� �ڵ����� �Ѵ�. �� �̻� finally�ȿ��� close�� �� �ص� �ȴ�.
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		try (BufferedReader br2 = br) {
			System.out.println(br2.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void java9try() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		try (br) {	//�ܺο��� ������ ���ҽ��� try���� �ȿ��� ����� �� �ְ� �����Ǿ���.
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
