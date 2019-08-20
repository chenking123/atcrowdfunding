package junit.test;

public class Test01 {

	public static void main(String[] args) {
		A a = new B();
		test(a);
	}

	public static void test(A a) {
		System.out.println("aaaaa");
	}

	public static void test(B b) {
		System.out.println("bbbbb");
	}
}

class A {

}

class B extends A {

}