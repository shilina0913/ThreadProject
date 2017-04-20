package com.unicss;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock extends Thread {
	private int id;

	public MyReentrantLock(int i) {
		this.id = i;
	}

	@Override
	public void run() {
		ReentrantLock lock = new ReentrantLock();
		try {
			lock.lock();
			System.out.println(id + "获得");
			Thread.sleep((int) (Math.random() * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(id + "释放");
			lock.unlock();
		}
	}

	public static void main(String args[]) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			service.submit(new MyReentrantLock(i));
		}
		service.shutdown();
	}
}
