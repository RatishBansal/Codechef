package com.ratish.JULY17Challenge;

/*
https://www.codechef.com/JULY17/problems/IPCTRAIN
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class IPCTRAIN {
	private class Node {
		long lecture;
		long day;
		long sadIndex;

		public Node(long day, long lecture, long sadIndex) {
			this.day = day;
			this.lecture = lecture;
			this.sadIndex = sadIndex;
		}
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0) {
			String[] str = br.readLine().split(" ");

			long N = Long.parseLong(str[0]);
			long D = Long.parseLong(str[1]);
			PriorityQueue<Node> dayMinheap = new PriorityQueue<>(new Comparator<Node>() {
				public int compare(Node node1, Node node2) {
					if (node1.day < node2.day) {
						return -1;
					}
					if (node1.day > node2.day) {
						return 1;
					}
					return 0;
				};
			});
			PriorityQueue<Node> sadMaxheap = new PriorityQueue<>(new Comparator<Node>() {
				public int compare(Node node1, Node node2) {
					if (node1.sadIndex > node2.sadIndex) {
						return -1;
					}
					if (node1.sadIndex < node2.sadIndex) {
						return 1;
					}
					return 0;
				};
			});
			while (N-- > 0) {
				str = br.readLine().split(" ");
				dayMinheap.add(new IPCTRAIN().new Node(Long.parseLong(str[0]), Long.parseLong(str[1]),
						Long.parseLong(str[2])));
			}
			for (int i = 1; i <= D; i++) {
				while (dayMinheap.peek() != null && dayMinheap.peek().day <= i) {
					Node node = dayMinheap.remove();
					sadMaxheap.add(node);
				}
				if (sadMaxheap.peek() != null) {
					sadMaxheap.peek().lecture = sadMaxheap.peek().lecture - 1;
					if (sadMaxheap.peek().lecture == 0) {
						sadMaxheap.remove();
					}
				}
			}
			long answer = 0;
			Iterator<Node> list = sadMaxheap.iterator();
			while (list.hasNext()) {
				Node node = list.next();
				answer = answer + node.lecture * node.sadIndex;
			}
			System.out.println(answer);
		}
	}
}