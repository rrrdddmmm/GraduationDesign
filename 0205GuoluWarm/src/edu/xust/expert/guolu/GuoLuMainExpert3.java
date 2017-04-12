package edu.xust.expert.guolu;

import edu.xust.expert.Expert;

public class GuoLuMainExpert3 implements Expert {

	@Override//方法的重写
	public void start() {
		// TODO Auto-generated method stub
		try {
				synchronized(this){
					new EachMembership(3).ff();
				}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}