package com.unicss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairReentrantLock {

	private static ReentrantLock2 fairLock = new ReentrantLock2(true);
	private static ReentrantLock2 unfairLock = new ReentrantLock2(false);
	public static int index = 0;

	public static class ReentrantLock2 extends ReentrantLock {
		public ReentrantLock2(boolean fair) {
			super(fair);
		}

		public List<Thread> getQueuedThread() {
			List<Thread> list = new ArrayList<Thread>(super.getQueuedThreads());
			Collections.reverse(list);
			return list;

		}
	}

	public static class Job extends Thread {

		public void fair() {
			fairLock.lock();
			System.out.print("current:" + index + " waiting：");
			List<Thread> list = fairLock.getQueuedThread();
			list.forEach((s) -> System.out.print(s + " "));
			System.out.println();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fairLock.unlock();
			index++;
		}

		@Override
		public void run() {
			fair();
		}
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 5; i++) {
			service.submit(new Job());
		}
	}

}
