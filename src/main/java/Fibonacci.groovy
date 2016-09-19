import groovy.transform.Memoized

/**
 * Created by dshue1 on 9/19/16.
 */
class Fibonacci {
	long fastFibo(long n) {
		long start =System.currentTimeMillis()

		def fibo = (1..n).inject([1L, 1L, 0L]) {interim, it ->
			if (it <= 2)
				interim[2] = 1
			else {
				interim[2] = interim[0] + interim[1]
				interim[0] = interim[1]
				interim[1] = interim[2]
			}
			interim
		}
		long end = System.currentTimeMillis()

		println 'fast fibo took ' + (end - start) + ' ms'

		fibo[2]
	}

	/**
	 * Although memoize substantially increases the calculation speed, it can still cause stack overflow.
	 *
	 * @param n
	 * @return
	 */
	long slowButMemoizedFibo(long n) {
		long start =System.currentTimeMillis()

		def fibo = fibo(n)
		long end = System.currentTimeMillis()

		println 'slow fibo took ' + (end - start) + ' ms'

		fibo
	}

	@Memoized
	private long fibo(long n) {
		n < 2 ? n : fibo(n - 2) + fibo(n - 1)
	}
}
