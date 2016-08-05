/**
 * Created by dshue1 on 7/25/16.
 */
class GroovySolution {
	static void main(String[] args) {
		System.out.println(isValidBoard(BOARD_VALID_COMPLETE));
	}

	static boolean isValidBoard(def board) {
		// TODO: fill this in
		//println 'row check: ' + checkRow(board)
		def columnRow = getBoardInColumn(board)
		//println columnRow
		//println 'column check' + checkRow(columnRow)

		def gridRow = getBoardInGrid(board)
		println gridRow
		//println 'grid check ' + checkRow(gridRow)

		return checkRow(board) && checkRow(columnRow) && checkRow(gridRow)
	}

	static final def BOARD_VALID_COMPLETE = [
	    [1,2,3,4,5,6,7,8,9],
	    [4,5,6,7,8,9,1,2,3],
	    [7,8,9,1,2,3,4,5,6],
	    [8,9,1,2,3,4,5,6,7],
	    [2,3,4,5,6,7,8,9,1],
	    [5,6,7,8,9,1,2,3,4],
	    [6,7,8,9,1,2,3,4,5],
	    [9,1,2,3,4,5,6,7,8],
	    [3,4,5,6,7,8,9,1,2]
	]

	static final def CELL = [1,2,3,4,5,6,7,8,9] as Set

	private static def getBoardInGrid(def original) {
		def gridResult = [].withDefault {[]}
		original.eachWithIndex{row, rowNum ->
			row.eachWithIndex{cell, columnNum ->
				def idx = (columnNum / 3 + ((rowNum / 3) as int) * 3) as int
				gridResult[idx] << cell
			}
		}
		gridResult
	}

	private static def getBoardInColumn(def original) {
		def columnRow = original.inject([].withDefault {[]}) {result, it ->
			it.eachWithIndex {element, index ->
				result[index] << element
			}
			result
		}
		columnRow
	}


	private static checkRow(def board) {
		Boolean valid = board.inject(true) {Boolean result, it ->
			def localList = it.collect()
			localList.removeAll(0)
			def smallSet = localList as Set
			result = result && (localList.size() == smallSet.size()) && CELL.containsAll(smallSet)
			result
		}
		valid
	}
}






