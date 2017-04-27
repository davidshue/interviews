package tree;

/**
 * Created by david on 3/15/17.
 */
public class StringToInt {
    public static void main(String[] args) {
        String s = "1234560";
        int value = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1, j=1; i >= 0; i--, j *=10) {
            value += (chars[i] - '0') * j;
        }
        System.out.println(value);
    }
}
