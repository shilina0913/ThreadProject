package com.unicss;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadState {
	public static class Waiting implements Runnable {
		@Override
		public void run() {
			synchronized (Waiting.class) {
				System.out.println(1);
				try {
					Waiting.class.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Waiting(), "t1").start();
		new Thread(new Waiting(), "t2").start();
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("thread id:" + threadInfo.getThreadId() + " thread name:" + threadInfo.getThreadName()
					+ " thread state" + threadInfo.getThreadState());
		}

	}

}
