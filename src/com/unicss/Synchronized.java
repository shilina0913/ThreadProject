package com.unicss;

public class Synchronized {
	public int sum;

	public synchronized void add(int i) {
		System.out.println("进入累加");
		sum = sum + i;
		while (sum > 5) {
			return;
		}
		add(1);
	}

	public static void main(String[] args) {
		Synchronized s = new Synchronized();
		s.add(1);
	}
}
