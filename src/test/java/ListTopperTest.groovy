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
		Map<Integer, Integer> treeMap = new TreeMap<>()

		Random rand = new Random()

		(5..1).each {
			treeMap[it] = rand.nextInt(10)
		}

		println treeMap

		println treeMap.firstKey()
	}
}
