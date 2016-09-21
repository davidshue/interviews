package fb

/**
 * Created by dshue1 on 9/20/16.
 */
class BugFinder {
	int realBug
	int getBugVersion(int n) {
		realBug = new Random().nextInt(n) + 1

		println 'realBug ' + realBug

		return _getBugVersion(1, n)

	}


	private int _getBugVersion(int start, int n) {
		if (start == n) {
			return n
		}
		println "$start $n"
		int mid = (n - start).intdiv(2)
		if (isBugBefore(start + mid)) {
			return _getBugVersion(start, start + mid)
		}
		else {
			return _getBugVersion(start + mid + 1, n)
		}
	}

	private boolean isBugBefore(int n) {
		realBug <= n
	}
}
