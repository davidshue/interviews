import org.junit.Test

import static junit.framework.TestCase.assertFalse
import static junit.framework.TestCase.assertTrue

/**
 * Created by dshue1 on 7/25/16.
 */
class SudokuSolutionTest {
	@Test
	void testValidSolutions() {
		def validData =
		[
			[0,0,3,4,5,6,7,8,9],
			[4,5,6,7,8,9,1,2,3],
			[7,8,9,1,2,3,4,5,6],
			[8,9,1,2,3,4,5,6,7],
			[2,3,4,5,6,7,8,9,1],
			[5,6,7,8,9,1,2,3,4],
			[6,7,8,9,1,2,3,4,5],
			[9,1,2,3,4,5,6,7,8],
			[3,4,5,6,7,8,9,1,2]
		]

		assertTrue GroovySolution.isValidBoard(validData)
	}

	@Test
	void testInvalidData() {
		def validData =
			[
				[1,2,3,4,5,6,7,8,9],
				[2,3,4,5,6,7,8,9,1],
				[3,4,5,6,7,8,9,1,2],
				[4,5,6,7,8,9,1,2,3],
				[5,6,7,8,9,1,2,3,4],
				[6,7,8,9,1,2,3,4,5],
				[7,8,9,1,2,3,4,5,6],
				[8,9,1,2,3,4,5,6,7],
				[9,1,2,3,4,5,6,7,8]
			]

		assertFalse GroovySolution.isValidBoard(validData)
	}

	@Test
	void testUnsolvedData() {
		def validData =
			[
				[1,2,3,4,5,6,7,8,9],
				[0,0,0,0,0,0,0,0,1],
				[0,4,5,0,7,8,0,0,2],
				[4,5,6,7,8,9,1,2,3],
				[0,0,7,0,0,1,0,0,4],
				[0,0,8,0,0,2,0,0,5],
				[7,8,9,1,2,3,4,5,6],
				[0,0,1,0,0,0,0,0,0],
				[0,0,2,0,4,5,0,7,8]
			]

		assertTrue GroovySolution.isValidBoard(validData)
	}
}
