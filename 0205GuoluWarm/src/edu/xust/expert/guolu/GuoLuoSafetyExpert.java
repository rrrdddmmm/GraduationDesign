package edu.xust.expert.guolu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.expert.Expert;
import edu.xust.expert.guolu.count.AcceptData;
import edu.xust.expert.guolu.count.Economy;
import edu.xust.expert.guolu.count.KeyFactor;
import edu.xust.expert.guolu.count.Reliability;

;

public class GuoLuoSafetyExpert implements Expert {//接口
	private static Logger log = LoggerFactory.getLogger(GuoLuoSafetyExpert.class);

	@Override
	/*
	 * android开发中经常看到@Override是什么意思呢？
	   @Override是伪代码,表示重写(当然不写也可以),不过写上有如下好处: 
	   1、可以当注释用,方便阅读 
	   2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的,如果没有则报错 
	        比如你如果没写@Override而你下面的方法名又写错了,这时你的编译器是可以通过的,导致你找不到错误
	        相反如果你写上@Override时编译器会提示你复写方法失败，以至比快速找到错误
	   (它以为这个方法是你的子类中自己增加的方法) 

	 */
	public void start() {//函数的重写
		// TODO Auto-generated method stub
		try {
			AcceptData A1 =new AcceptData();
			KeyFactor K1=new KeyFactor();
			Reliability W1=new Reliability();
			Economy E1=new Economy();
			//A1.datajieshou();
			//for(int i=0;i<18;i++)
				//System.out.println(A1.a[i]);
			K1.guanianzhongyaodu();//关键重要度
			W1.ff();//可靠度
			E1.fenglei();//经济性
			//System.out.println(A1.t);
			System.out.println("程序结束！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
