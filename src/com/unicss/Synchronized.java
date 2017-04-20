package com.unicss;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Synchronized extends Thread {
	public int sum;
	public int index;

	public Synchronized(int i) {
		index = i;
	}

	@Override
	public void run() {
		add();
	}

	public synchronized void add() {
		System.out.println("线程" + index + "进入累加");
		sum = sum + 1;
		while (sum > 2) {
			return;
		}
		add();
		sum++;
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++)
			service.execute(new Synchronized(i) {
			});
	}
}
