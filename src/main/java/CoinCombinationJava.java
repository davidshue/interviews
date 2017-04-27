import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by david on 3/5/17.
 */
public class CoinCombinationJava {
    public List<Map<Coin, Integer>> combinations(int cents) {
        final List<Map<Coin, Integer>> result = new ArrayList<>();
        Coin.upToMax(cents).forEach((Coin coin) -> {
            result.addAll(findCombination(new LinkedHashMap<>(), cents, coin));

        });
        return result;
    }

    public List<Map<Coin, Integer>> findCombination(LinkedHashMap<Coin, Integer> seed, int cents, Coin start) {
        if (cents == 0) {
            return Arrays.asList(seed);
        }

        final List<Map<Coin, Integer>> result = new ArrayList<>();
        Coin.upToMax(start.value).forEach(coin -> {
            if (cents >= coin.value) {
                LinkedHashMap<Coin, Integer> newSeed = (LinkedHashMap) seed.clone();
                newSeed.put(coin, newSeed.get(coin) != null? newSeed.get(coin) + 1 : 1);
                result.addAll(findCombination(newSeed, cents - coin.value, coin));
            }
        });

        return result;
    }
}
