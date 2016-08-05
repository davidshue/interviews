public class Solution {

	public static void main(String[] args) {
		System.out.println(isValidBoard(BOARD_VALID_COMPLETE));
	}

	static boolean isValidBoard(int[][] board) {
		// TODO: fill this in
		return false;
	}

	static final int[][] BOARD_VALID_COMPLETE = {
		{ 1,2,3,4,5,6,7,8,9 },
		{ 4,5,6,7,8,9,1,2,3 },
		{ 7,8,9,1,2,3,4,5,6 },
		{ 8,9,1,2,3,4,5,6,7 },
		{ 2,3,4,5,6,7,8,9,1 },
		{ 5,6,7,8,9,1,2,3,4 },
		{ 6,7,8,9,1,2,3,4,5 },
		{ 9,1,2,3,4,5,6,7,8 },
		{ 3,4,5,6,7,8,9,1,2 }
	};

}
