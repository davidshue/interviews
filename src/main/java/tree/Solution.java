package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();*/
        int n = 6;
        int k = 2;
        int[][] val = {{10, 15}, {12, 17}, {16, 18}, {18, 13}, {30, 10}, {32, 1}};
        List<Position> poles = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            //int alt = in.nextInt();
            //int weight = in.nextInt();
            int alt = val[i][0];
            int weight = val[i][1];
            poles.add(new Position(alt, weight));
        }
        List<Integer> ints = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            ints.add(i);
        }
        Map<Integer, Integer> costsByAltitude = costsByAltitude(n, poles);

        List<List<Integer>> combinations = combinations(ints, k);

        int min = getMinCost(costsByAltitude, poles, combinations);

        System.out.println(min);

    }

    private static Integer getMinCost(Map<Integer, Integer> costsByAltitude, List<Position> poles, List<List<Integer>> combinations) {
        return combinations.stream().map(comb -> costByCombination(costsByAltitude, poles, comb)).min(Integer::compare).get();
    }

    private static Integer costByCombination(Map<Integer, Integer> costsByAltitude, List<Position> poles, List<Integer> combination) {
        if (combination.size() == 1) {
            return costsByAltitude.get(combination.get(0));
        }
        int cost = 0;
        for (int i = 0; i < combination.size() - 1; i++) {
            List<Position> subPoles = poles.subList(combination.get(i), combination.get(i+1));
            cost += getCost(subPoles, poles.get(combination.get(i)));
        }
        cost += costsByAltitude.get(combination.get(combination.size() - 1));
        return cost;
    }

    private static Map<Integer, Integer> costsByAltitude(int n, List<Position> poles) {
        Map<Integer, Integer> costs = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            List<Position> subPoles = poles.subList(i, n);
            costs.put(i, getCost(subPoles, subPoles.get(0)));
        }
        return costs;
    }

    private static Integer getCost(List<Position> positions, Position bottom) {
        return positions.stream().map( p -> (p.alt - bottom.alt) * p.weight).reduce((sum, n) -> sum + n).get();
    }

    private static List<List<Integer>> combinations(List<Integer> ints, int depth) {
        List<Integer> seed = Arrays.asList(0);
        List<List<Integer>> combs = _combinations(seed, ints, depth - 1);

        return combs;
    }

    private static List<List<Integer>> _combinations(List<Integer> seeds, List<Integer> ints, int num) {
        if (num == 0 || seeds.size() == ints.size()) {
           return Arrays.asList(seeds);
        }
        List<List<Integer>> combs = new ArrayList<>();
        int min = seeds.get(seeds.size() - 1);
        for (Integer anInt : ints) {
            if (!seeds.contains(anInt) && anInt > min) {
                List<Integer> item = new ArrayList<>(seeds);
                item.add(anInt);
                combs.addAll(_combinations(item, ints, num - 1));
            }
        }
        return combs;
    }
}

class Position {
    int alt;
    int weight;
    Position(int alt, int weight) {
        this.alt = alt;
        this.weight = weight;
    }
}