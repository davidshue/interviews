package vungle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dshue1 on 8/19/16.
 */
public class GridPath {
	public static void main(String[] args) {
		int[][] grid = {{0,0,0,0}, {0,1,0,0}, {0,0,0,0},{0,0,0,0}};

		GridPath pathFinder = new GridPath();

		int paths = pathFinder.findNumOfPath(grid);

		System.out.println("total paths: " + paths);
	}

	public Integer findNumOfPath(int[][] grid) {
		Coordinate start = new Coordinate(0, 0);


		return path(start, grid, 0);
	}

	private int path(Coordinate cord, int[][] grid, int num) {
		if (!isValid(cord, grid)) {
			return num;
		}
		if (isEnd(cord, grid))
			return num + 1;
		List<Coordinate> next = nextCords(cord, grid);
		for(Coordinate it : next) {
			num = path(it, grid, num);
		}

		return num;
	}

	private boolean isEnd(Coordinate cord, int[][] grid) {
		return cord.x == grid.length -1 && cord.y == grid.length -1;
	}

	private boolean isValid(Coordinate cord, int[][] grid) {
		return grid[cord.y][cord.x] == 0;
	}

	private List<Coordinate> nextCords(Coordinate current, int[][] grid) {
		List<Coordinate> result = new ArrayList<>();

		if (current.x < grid.length -1) {
			Coordinate coord1 = new Coordinate(current.x +1, current.y);
			if (isValid(coord1, grid)) result.add(coord1);
		}

		if (current.y < grid.length -1) {
			Coordinate coord2 = new Coordinate(current.x, current.y + 1);
			if (isValid(coord2, grid)) result.add(coord2);
		}

		return result;
	}

	static class Coordinate {
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
