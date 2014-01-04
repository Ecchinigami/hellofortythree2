package model;

import java.util.Vector;

public class VieAble implements Runnable {

	public Action actionlist[];

	public VieAble() {

	}

	public void run() {
		synchronized (ThreadUtil.class) {
			update();
			perform();
		}
	}

	public void update(){

	}
	public void perform(){

	}

}