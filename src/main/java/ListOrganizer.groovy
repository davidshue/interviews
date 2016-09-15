

/**
 * Created by dshue1 on 8/11/16.
 */
class ListOrganizer {
	List<Integer> organize(List<Integer> input) {
		Tuple2<List<Integer>, List<Integer>> tuple = input.inject(new Tuple2([], [])) {Tuple2 tuple, int it ->
			it? tuple.first << it : tuple.second << it
			tuple
		}

		tuple.first.addAll(tuple.second)

		tuple.first
	}

}
