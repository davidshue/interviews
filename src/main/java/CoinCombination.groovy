/**
 * Created by dshue1 on 9/15/16.
 */
class CoinCombination {
	List<Map<Coin, Integer>> combinations(int cents) {
		Coin.upToMax(cents).inject([]) {result, coin ->
			if (cents >= coin.value) {
				Map<Coin, Integer> seed = [(coin) : 1]
				result += findCombination(seed, cents - coin.value, coin)
			}

			result
		}
	}

	private List<Map<Coin, Integer>> findCombination(Map<Coin, Integer> seed, int cents, Coin max) {
		if (!cents) {
			return [seed]
		}
		Coin.upToMax(max.value).inject([]) {result, coin ->
			if (cents >= coin.value) {
				Map<Coin, Integer> newSeed = seed.clone()
				newSeed[coin] = newSeed.get(coin, 0) + 1
				result += findCombination(newSeed, cents - coin.value, coin)

			}
			result
		}
	}
}
