import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 3/4/17.
 */
public class SudokoValidator {
    public boolean isValid(List<Integer> board) {
        return checkSize(board) && checkRank(board) && checkFile(board) && checkGrid(board);
    }

    private boolean checkSize(List<Integer> board) {
        if (board.size() != 81) {
            throw new RuntimeException("size not equal t0o 81");
        }
        return true;
    }

    public boolean checkValue(List<Integer> grid, String type, int num) {
        if (grid.stream().anyMatch(element -> element > 9 || element < 1)) {
            throw new RuntimeException("invalid value in the " + type + " #" + num);
        }
        if (grid.stream().distinct().count() != 9) {
            throw new RuntimeException("duplicate values in " + type + " #" + num);
        }
        return true;
    }

    private boolean checkRank(List<Integer> board) {
        for (int i = 0; i < 9; i++) {
            int start = i * 9;
            checkValue(board.subList(start, start + 9), "rank", i+1);
        }
        return true;
    }

    private boolean checkFile(List<Integer> board) {
        for (int i = 0; i < 9 ; i++) {
            checkValue(getFile(board, i), "file", i+1);
        }
        return true;
    }

    private List<Integer> getFile(List<Integer> board, int file) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            result.add(board.get(file + 9*i));
        }
        return result;
    }

    private boolean checkGrid(List<Integer> board) {
        for (int i = 0; i < 9 ; i++) {
            checkValue(getGrid(board, i), "3x3grid", i+1);
        }
        return true;
    }

    private List<Integer> getGrid(List<Integer> board, int grid) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int start = i % 3 * 3 + i/3 * 27;
            result.add(board.get(start));
            result.add(board.get(start + 1));
            result.add(board.get(start + 2));
            result.add(board.get(start + 9));
            result.add(board.get(start + 10));
            result.add(board.get(start + 11));
            result.add(board.get(start + 18));
            result.add(board.get(start + 19));
            result.add(board.get(start + 20));
        }
        return result;
    }

}
