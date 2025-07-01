package com.kh.step3;

import java.awt.Toolkit;

public class BeepThread implements Runnable {
	
	// 첫번째 작업 - 경고음 5번 울리기 ->BeepThread
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
