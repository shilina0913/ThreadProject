package com.unicss;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
	public static class TimeWaiting implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new TimeWaiting(), "timeWaiting").start();
		// TODO Auto-generated method stub
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println(
					"thread id:" + threadInfo.getThreadId() + " thread name:" + threadInfo.getThreadName() + ";");
		}

	}

}
