import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * Created by dshue1 on 8/8/16.
 */
class ListTopperTest {

	@Test
	void testTopper() {
		def originalList = 1..1000

		def expected = 901..1000

		def topper = new ListTopper()
		def result = topper.top(originalList, 100)

		println result


		assertEquals expected, result
	}

	@Test
	void testTreeMap() {
		Random rand = new Random()

		TreeMap<Integer, Integer> treeMap = (5..1).inject(new TreeMap<Integer, Integer>()) {map, it ->
			map[it] = rand.nextInt(10)
			map
		}

		println treeMap

		println treeMap.firstKey()
	}
}
