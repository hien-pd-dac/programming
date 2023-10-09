package hienpd.practice.datastructure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DataStructure {
	public static void main(String[] args) {
		PlayWithString();
		PlayWithList();
		PlayWithMap();
		PlayWithSet();
		PlayWithDeque();
		PlayWithPriorityQueue();
	}

	private static void PlayWithString() {
		System.out.printf("%n--- static string with String---%n");
		var str1 = new String("str1");
		for (var i = 0; i < str1.length(); i++) {
			System.out.printf("%s%n", str1.charAt(i));
		}

		var str2 = str1.concat("-appended");
		System.out.printf("str1=%s%n", str1); // str1 does not change
		System.out.printf("str2=%s%n", str2);

		var str3 = str2.substring(0, 2);
		System.out.printf("%s%n", str3);

		System.out.printf("%n--- dynamic string with StringBuilder ---%n");
		var strb1 = new StringBuilder("strb1");
		for (var i = 0; i < strb1.length(); i++) {
			System.out.printf("%s%n", strb1.charAt(i));
		}
		var strb2 = strb1.append("-appended");
		System.out.printf("strb1=%s%n", strb1); // strb1 changes after append
		System.out.printf("strb2=%s%n", strb2);
		var str4 = strb1.substring(0, 2); // str4 is a String
		System.out.printf("str4=%s%n", str4);

		return;
	}

	private static void PlayWithList() {
		System.out.printf("%n--- static array with T[] ---");
		// init
		int[] intArr = new int[3];
		// add/set
		intArr[0] = 0;
		intArr[1] = 1;
		intArr[2] = 2;
		// or int[] intArr = {0, 1, 2};
		System.out.printf("%s, length=%d%n", intArr, intArr.length);
		// interator
		for (var e : intArr) {
			System.out.printf("%s%n", e);
		}

		System.out.println("%n--- dynamic array with ArrayList<T> ---");
		// init
		List<Integer> dynamicArray = new ArrayList<Integer>();
		// add
		dynamicArray.add(0);
		dynamicArray.add(1);
		dynamicArray.add(2);
		dynamicArray.add(1, 3); // insert 3 at the index=1
		System.out.printf("%s, length=%d%n", dynamicArray, dynamicArray.size());
		// interator
		for (var e : dynamicArray) {
			System.out.printf("%s%n", e);
		}
		// remove
		dynamicArray.remove(3);
		System.out.printf("%s%n", dynamicArray);

		System.out.printf("%n--- linked-list with LinkedList<T> ---%n");
		// init
		List<Integer> linkedList = new LinkedList<Integer>();
		// add
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(2);
		System.out.printf("%s, length=%d%n", linkedList, linkedList.size());
		// iterator
		for (var e : linkedList) {
			System.out.printf("%s%n", e);
		}
		// remove
		linkedList.remove(1);
		System.out.printf("%s%n", linkedList);
		return;
	}

	private static void PlayWithMap() {
		System.out.printf("%n--- map with HashMap<T, V> ---%n");
		// init
		Map<String, Integer> m = new HashMap<String, Integer>();
		// add
		m.put("k1", 1);
		m.put("k2", 2);
		// interator
		for (var e : m.entrySet()) {
			System.out.printf("key=%s%n", e.getKey());
			System.out.printf("value=%s%n", e.getValue());
		}
		// lookup
		if (m.get("k3") == null) {
			System.out.printf("key=k3 is not found.%n");
		}
		// remove (if present)
		m.remove("k3");

		return;
	}

	private static void PlayWithSet() {
		System.out.printf("%n--- Set with HashSet<T> %n");
		// init
		Set<Integer> s = new HashSet<Integer>();
		// add
		s.add(0);
		s.add(1);
		s.add(2);
		System.out.printf("%s%n", s);
		// interator
		for (var e : s) {
			System.out.printf("%s%n", e);
		}
		// remove (if present)
		s.remove(1);
		System.out.printf("%s%n", s);
	}

	private static void PlayWithDeque() {
		System.out.printf("%n--- Deque with LinkedList<T> ---%n");
		// init
		Deque<Integer> d = new LinkedList<Integer>();
		// add (first, last)
		d.addFirst(1);
		d.addFirst(0);
		d.addLast(2);
		System.out.printf("%s, length=%d%n", d, d.size());
		// iterator
		for (var e : d) {
			System.out.printf("%s%n", e);
		}
		// poll
		System.out.printf("%s%n", d.getFirst());
		System.out.printf("%s%n", d.getLast());
		// remove (first, last)
		d.removeFirst();
		d.removeLast();
		System.out.printf("%s%n", d);
		return;
	}

	private static void PlayWithPriorityQueue() {
		System.out.printf("%n--- PriorityQueue<T> ---%n");
		// init
		var d = new PriorityQueue<Integer>();
		d.add(1);
		d.add(0);
		d.add(2);
		System.out.printf("%s, length=%d%n", d, d.size());
		// iterator
		for (var e : d) {
			System.out.printf("%s%n", e);
		}
		// peek
		System.out.printf("peek: %s%n", d.peek());
		// poll
		d.poll();
		System.out.printf("after poll(): %s%n", d);
		// remove
		d.remove(2);
		System.out.printf("after remove(2): %s%n", d);

		return;
	}
}
