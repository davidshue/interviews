package shippo

import org.junit.Test

/**
 * Created by dshue1 on 9/20/16.
 */
class UrlTripletTopperTest {
	@Test
	void test() {
		UrlTripletTopper topper = new UrlTripletTopper()
		def input = []
		(1..100).inject(input) {temp, i ->
			temp << new Tuple2(i, 'xyz')
			temp
		}
		(1..50).inject(input) {temp, i ->
			temp << new Tuple2(i, 'abc')
			temp
		}
		(1..20).inject(input) {temp, i ->
			temp << new Tuple2(i, 'opq')
			temp
		}
		(1..10).inject(input) {temp, i ->
			temp << new Tuple2(i, 'cmb')
			temp
		}
		println input

		def out = topper.top10Triplets(input)

		println out
	}
}
