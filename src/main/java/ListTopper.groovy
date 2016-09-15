/**
 * Created by dshue1 on 8/8/16.
 */
class ListTopper {
	List<Integer> top(List<Integer> ints, int topCount) {
		if (ints.size() <= topCount) {
			return ints.collect()
		}

		KeyCount keyCount = new KeyCount()

		def result = ints.inject([]) {res, it ->
			addNewInt(res, keyCount,  topCount, it)
			res
		}

		result
	}

	private void addNewInt(List<Integer> top, KeyCount keyCount, int topCount, int num) {
		if (top.size() < topCount)
		{
			top << num
			refreshLookupMap(keyCount, num)
			return
		}
		top << num

		def min = refreshLookupMap(keyCount, num)
		top.removeElement(min)
	}

	private int refreshLookupMap(KeyCount keyCount, int num) {
		if (!keyCount) {
			keyCount[num] = 1
			println keyCount.total
			keyCount.total++
			return num
		}

		def min = (int) keyCount.keySet().first()

		if (num < min) {
			return -1
		}

		def minNum = keyCount[min]
		if (minNum == 1 && keyCount.total >= 100) keyCount.remove(min)
		else {
			keyCount[min] = minNum - 1
			keyCount.setTotal(keyCount.getTotal() + 1)
		}

		def numNum = keyCount[num]
		if (numNum) keyCount[num] = numNum + 1
		else keyCount[num] = 1

		keyCount.setTotal(keyCount.getTotal() + 1)

		min
	}


}
