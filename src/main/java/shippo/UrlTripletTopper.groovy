package shippo

/**
 * Created by dshue1 on 9/20/16.
 */
class UrlTripletTopper {
	Map<Tuple, Integer> top10Triplets(List<Tuple2<Integer, String>> idUrls) {
		def countMap = [:]
		def top10CountMap = [:]

		idUrls.inject([:]) {Map<Integer, Tuple> userTriplet, idUrl ->
			Tuple userTuple = userTriplet.get(idUrl.first, new Tuple('', '', ''))

			userTuple = new Tuple(userTuple[1], userTuple[2], idUrl.second)

			userTriplet.put(idUrl.first, userTuple)

			handleUrl(countMap, top10CountMap, userTuple)

			userTriplet

		}


		top10CountMap

	}

	private void handleUrl(countMap, top10CountMap, userTuple) {
		if (userTuple[0] && userTuple[1] && userTuple[2]) {
			countMap.put(userTuple, countMap.get(userTuple, 0) + 1)
			refreshTop(top10CountMap, userTuple, countMap[userTuple])
		}
	}

	private void refreshTop(top10CountMap, userTuple, count) {
		top10CountMap.put(userTuple, count)
		if (top10CountMap.size() > 10) {
			def min = top10CountMap.values().min()
			top10CountMap.filter{k, v -> v == min}
		}
	}
}
