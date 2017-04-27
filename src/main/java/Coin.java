import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by david on 3/5/17.
 */
public enum Coin {
    quarter(25),
    dime(10),
    nickel(5),
    penny(1);

    int value;

    Coin(int value) {
        this.value = value;
    }

    static List<Coin> upToMax(int max) {
        return Arrays.asList(Coin.values()).stream().filter(coin -> coin.value <= max).collect(Collectors.toList());
    }
}
