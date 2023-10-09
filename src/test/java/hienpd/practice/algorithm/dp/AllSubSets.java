package hienpd.practice.algorithm.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AllSubSets {
	private List<Integer> set;
	private Set<Integer> workingSet;
	private List<Set<Integer>> result;

	public AllSubSets(Set<Integer> set) {
		this.set = new ArrayList<Integer>(set);
		workingSet = new HashSet<Integer>();
		result = new ArrayList<Set<Integer>>();
	}

	public List<Set<Integer>> solve() {
		subSet(0);
		return result;
	}

	private void subSet(int fromIdx) {
		if (fromIdx > set.size() - 1) {
			result.add(new HashSet<Integer>(workingSet));
			return;
		}
		var item = set.get(fromIdx);
		workingSet.add(item);
		subSet(fromIdx + 1);
		workingSet.remove(item);
		subSet(fromIdx + 1);
	}
}
