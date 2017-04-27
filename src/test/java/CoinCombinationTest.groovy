import org.junit.Test

/**
 * Created by dshue1 on 9/15/16.
 */
class CoinCombinationTest {
	@Test
	void test() {
		CoinCombination comb = new CoinCombination()

		println comb.combinations(100)
	}

	@Test
	void testJava() {
		CoinCombinationJava ccj = new CoinCombinationJava();

		println ccj.combinations(100)
	}
}
