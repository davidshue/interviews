package tree;

/**
 * Created by david on 3/20/17.
 */
public class StringDescriber {
    public static void main(String[] args) {
        String s = "AaaabbBbCdDDD";
        String out = parse(s);
        System.out.println(out);
    }

    private static String parse(String s) {
        if (s == null || s.isEmpty()) {
            return "null or empty string";
        }
        int distance = 'A' - 'a';
        System.out.println(distance);
        char[] chars = s.toCharArray();
        char current = chars[0];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        if (current >= 'A' && current <= 'Z') {
            current -= distance;
        }
        for (char c : chars) {
            if (current == c || current + distance == c) {
                count++;
            }
            else {
                if (count != 0) sb.append(count).append(current);
                current = c;
                if (current >= 'A' && current <= 'Z') {
                    current -= distance;
                }
                count = 1;
            }
        }
        if (count != 0) sb.append(count).append(current);
        return sb.toString();
    }
}
