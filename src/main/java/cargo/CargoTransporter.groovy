package cargo

/**
 * Created by dshue1 on 8/5/16.
 */
class CargoTransporter {
	private static final def VALID_STATE = [Cargo.WOLF, Cargo.CABBAGE] as Set
	private static final def END_STATE = [Cargo.WOLF, Cargo.GOAT, Cargo.CABBAGE] as Set

	static void main(String[] args) {
		def transporter = new CargoTransporter()
		println transporter.validPath()
	}

	List<Tuple2<Cargo, Cargo>> validPath() {
		Cargo start = start()
		if (start == Cargo.NO_SOLUTION) {
			return [new Tuple2(start, start)]
		}
		List<Tuple2<Cargo, Cargo>> path = []
		def left = [Cargo.WOLF, Cargo.GOAT, Cargo.CABBAGE]
		left.removeElement(start)
		def right = []
		Cargo fromRight = rightPath(right, start)
		path << new Tuple2<Cargo, Cargo>(start, fromRight)

		while(fromRight != Cargo.FINISHED) {
			Cargo toRight = leftPath(left, fromRight)
			fromRight = rightPath(right, toRight)

			path << new Tuple2<Cargo, Cargo>(toRight, fromRight)
		}

		path
	}


	private Cargo start() {
		List<Cargo> start = []
		[Cargo.WOLF, Cargo.GOAT, Cargo.CABBAGE].each {
			def startState = [Cargo.WOLF, Cargo.GOAT, Cargo.CABBAGE]
			startState.removeElement(it)
			if (startState as Set == VALID_STATE) start << it
		}
		start ? start[0]: Cargo.NO_SOLUTION
	}

	private Cargo leftPath(List<Cargo> leftState, Cargo addition) {
		if (addition != Cargo.NONE)
			leftState << addition
		return leftState.remove(0)
	}

	private Cargo rightPath(List<Cargo> rightState, Cargo addition) {

		rightState << addition
		if (rightState.size() == 1)
			return Cargo.NONE

		if (rightState as Set == END_STATE)
			return Cargo.FINISHED

		if (rightState as Set == VALID_STATE)
			return Cargo.NONE

		return rightState.remove(0)
	}

	static enum Cargo {
		WOLF,
		GOAT,
		CABBAGE,
		NONE,
		NO_SOLUTION,
		FINISHED;
	}
}
