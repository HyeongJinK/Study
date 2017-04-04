package java9.privateininterfaces;

public interface JavaNineInterfaces {
	private void test () {
		System.out.println("private method");
	}
	private static void test2() {
		System.out.println("static private method");
	}
	
	default void call() {
		test();
	}
	static void call2() {
		test2();
	}
}
