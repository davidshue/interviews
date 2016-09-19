import org.junit.Test

/**
 * Created by dshue1 on 9/19/16.
 */
class FibonacciTest {
	@Test
	void testFastFibo() {
		Fibonacci tester = new Fibonacci()

		long fibo = tester.fastFibo(100)

		println fibo
	}

	@Test
	void testSlowFibo() {
		Fibonacci tester = new Fibonacci()

		long fibo = tester.slowButMemoizedFibo(100)

		println fibo
	}
}
