package edu.xust.expert.guolu;

public class Judge {
	public String  judge(double a){
		String flag;
		if(a>0 && a<0.65){
			flag="安全";
			//System.out.println("安全");
		}
		else{
			flag="预警";
			//System.out.println("预警");
		}
		return flag;	
	}	
}
