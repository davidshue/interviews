package vungle

/**
 * Created by dshue1 on 8/19/16.
 */
class GridPathFinder {
	Integer findNumOfPath(def grid) {
		Coordinate start = new Coordinate(x: 0, y:0)


		path(start, grid, 0)
	}

	private int path(Coordinate cord, def grid, int num) {
		if (!isValid(cord, grid)) {
			return num
		}
		if (isEnd(cord, grid))
			return num + 1
		def next = nextCords(cord, grid)
		next.each {
			num = path(it, grid, num)
		}
		num
	}

	private boolean isEnd(Coordinate cord, def grid) {
		cord.x == grid.size() -1 && cord.y == grid.size() -1
	}

	private boolean isValid(Coordinate cord, def grid) {
		!grid[cord.y][cord.x]
	}

	private List<Coordinate> nextCords(Coordinate current,def grid) {
		def result = []

		if (current.x < grid.size() -1) {
			Coordinate coord1 = new Coordinate(x: current.x +1, y: current.y)
			if (isValid(coord1, grid)) result << coord1
		}

		if (current.y < grid.size() -1) {
			Coordinate coord2 = new Coordinate(x: current.x, y: current.y + 1)
			if (isValid(coord2, grid)) result << coord2
		}

		result
	}
}
