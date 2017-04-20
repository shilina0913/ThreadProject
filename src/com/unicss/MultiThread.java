package com.unicss;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println(
					"thread id:" + threadInfo.getThreadId() + " thread name:" + threadInfo.getThreadName() + ";");
		}

	}

}
