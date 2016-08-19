package sysdig

import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * Created by dshue1 on 8/11/16.
 */
class ListOrganizerTest {
	@Test
	void testSortZeros() {
		ListOrganizer lo = new ListOrganizer()

		List<Integer> input = [1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0]

		println input

		List<Integer> expected = [1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0]

		List<Integer> output = lo.organize(input)

		assertEquals expected, output
	}
}
