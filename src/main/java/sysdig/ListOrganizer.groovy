package sysdig

/**
 * Created by dshue1 on 8/11/16.
 */
class ListOrganizer {
	List<Integer> organize(List<Integer> input) {
		def newlist = input.collect()
		input.each {

		}
		for (int i = 0; i < input.size(); i++) {
			Integer current = input[i]
			if (!current) {
				newlist << current
				newlist.remove(i)
			}
			println newlist
		}
		newlist
	}

}
