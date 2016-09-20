import groovy.transform.Memoized

/**
 * Created by dshue1 on 9/19/16.
 */
class Fibonacci {
	long fastFibo(long n) {
		long start =System.currentTimeMillis()

		def fibo = (1..n).inject(new Tuple2(0L, 1L)) {Tuple2 tuple, it ->
			new Tuple2(tuple.second, tuple.first + tuple.second)
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
