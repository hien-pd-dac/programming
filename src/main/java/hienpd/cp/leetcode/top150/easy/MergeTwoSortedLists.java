package hienpd.cp.leetcode.top150.easy;

// Category: LinkedList
// https://leetcode.com/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-interview-150
public class MergeTwoSortedLists {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		ListNode smaller;
		if (list1.val < list2.val) {
			smaller = list1;
			smaller.next = mergeTwoLists1(list1.next, list2);
			return smaller;
		}

		smaller = list2;
		smaller.next = mergeTwoLists1(list1, list2.next);
		return smaller;
	}
}
