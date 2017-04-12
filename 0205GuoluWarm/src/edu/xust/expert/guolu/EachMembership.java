package edu.xust.expert.guolu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.bodytrouble.GRQG_X;
import edu.xust.expert.guolu.bodytrouble.QBMS_X;
import edu.xust.expert.guolu.bodytrouble.QSGT_X;
import edu.xust.expert.guolu.bodytrouble.SLNB_X;
import edu.xust.expert.guolu.bodytrouble.SMQDS_X;
import edu.xust.expert.guolu.bodytrouble.SMQG_X;
import edu.xust.expert.guolu.entity.Configure;
import edu.xust.expert.guolu.entity.MainBasicData;
import edu.xust.expert.guolu.getData.GetMainBasicDataValues;
import edu.xust.expert.guolu.getData.SetConfigureValues;

/*求每一个类型的隶属值*/
public class EachMembership {
	private static Logger log = LoggerFactory.getLogger(EachMembership.class);
	private static int number;
	private List<MainBasicData>  MainDatas=new  GetMainBasicDataValues ().getMainBasicData
			("select * from GL_MainBasicData  where State=1  and GUOLUNUM="+number+" order by CJSJ desc");
	public EachMembership(int number){
		EachMembership.number=number;
	}
	public EachMembership(){
	}
	//GetMainBasicDataValues  GetMain = new  GetMainBasicDataValues ();
	List<Configure> con=new SetConfigureValues().setconfigureValues
			("select * from GL_configure");

	
	
/*
 * 主体8个本函数实现综合置信度的计算和插入表中
 * 获取主体表中的原始数据获取规为
 * ("select * from GL_MainBasicData  where State=0  order by CJSJ desc");
 */
	
	
	public void ff(){//主体设备处理函数
//		MainDatas=GetMain.getMainBasicData
//				("select * from GL_MainBasicData  where State=1  order by CJSJ desc");
		 //为后面的隶属函数做数据准备
		if(!MainDatas.isEmpty()){		
			/*实现获得总的前提置信度总和,计算每个置信度所占比例并
			 * 存入数组a[8]中以便函数getResult()使用
			 * 
			 * */
			SLNB_X a = new SLNB_X();//水冷凝壁泄漏
			//测试成功
			a.getrate();
			a.getResult();
			a.insert(number);
			//数据插入表中
			
			
			
			
			//此锅炉水冷壁结焦无法判断
			/*SLB_X b = new SLB_X();//水冷壁结焦
			//测试成功
			b.getrate();
			b.getResult();
			b.insert(number);
			*/
			
			
			QBMS_X c = new QBMS_X();//汽包满水故障
			//测试成功
			c.getrate();
			c.getResult();
			c.insert(number);
			
			
			QSGT_X d = new QSGT_X();//'汽水共腾'
			//测试成功
			d.getrate();
			d.getResult();
			d.insert(number);
			
			
			SMQDS_X e = new SMQDS_X();//省煤器堵塞
			//测试成功
			e.getrate();
			e.getResult();
			e.insert(number);
			
			
			SMQG_X f = new SMQG_X();//'省煤气罐泄漏'
			//测试成功
			f.getrate();
			f.getResult();
			f.insert(number);

			
			GRQG_X g = new GRQG_X();//过热器官泄露'
			//测试成功
			g.getrate();
			g.getResult();
			g.insert(number);	
			
			
			
			String update_state="update GL_MainBasicData set State=1 where State=0";		
			//实现将State=0改为State=1
			System.out.println("主体设备正在执行—————————刷新—————————");
		boolean flag=	MyDB.executeSql(update_state);	
		
			log.info(flag?"主体设备参数更新成功":"主体设备参数更新失败");  //mei you shu ju 	
		}else{
			log.info("主体设备数据没有更新");  //mei you shu ju 
		}	
	}
	
	/*求蒸汽压力下降的隶属值*/
	public double getZQYLMembership(){
		calculate cal = new calculate();
		double ZQYL_L=0;
		if(MainDatas.get(0).getW_ZQYL()>=MainDatas.get(MainDatas.size()-1).getW_ZQYL()){//蒸汽压力下降
			for(int j=0;j<con.size();j++)
				if(con.get(j).getPareName().equals("ZQYL_XJ"))
					ZQYL_L= cal.LiShuZhi(MainDatas.get(0).getW_ZQYL()-MainDatas.get(con.size()-1).getW_ZQYL(),
							con.get(j).getFunCF(),con.get(j).getMaxValue(), con.get(j).getMinValue());
				//break;
//		System.out.println("蒸汽压力的隶属值="+ZQYL_L);
		}
		return ZQYL_L;
	}
	/*求蒸汽温度上升的隶属值ֵ*/
	public double getZQWDMembership(){
		calculate cal = new calculate();
		double ZQWD_L=0;
		if(MainDatas.get(0).getW_ZQWD()-MainDatas.get(con.size()-1).getW_ZQWD()<=0){
			ZQWD_L=0;
		}
		else{
			for(int j=0;j<con.size();j++){
				if(con.get(j).getPareName().equals("ZQWD")){
						ZQWD_L= cal.LiShuZhi(MainDatas.get(0).getW_ZQWD()-MainDatas.get(con.size()-1).getW_ZQWD(),
						con.get(j).getFunCF(),
						con.get(j).getMaxValue(), 
						con.get(j).getMinValue());
						//break;
					}
				}
			}	
//		System.out.println("蒸汽温度的隶属值="+ZQWD_L);
		return ZQWD_L;
	}
	/*求蒸汽温度下降的隶属值ֵ*/
	public double getZQWDxjMembership(){
		calculate cal = new calculate();
		double ZQWD_L=0;
		if(MainDatas.get(0).getW_ZQWD()-MainDatas.get(MainDatas.size()-1).getW_ZQWD()<0)
			for(int j=0;j<con.size();j++){
				if(con.get(j).getPareName().equals("ZQWD")){
						ZQWD_L= cal.LiShuZhi(MainDatas.get(MainDatas.size()-1).getW_ZQWD()-MainDatas.get(0).getW_ZQWD(),
						con.get(j).getFunCF(),
						con.get(j).getMaxValue(), 
						con.get(j).getMinValue());
						break;
					}
			}
		return ZQWD_L;
}	
	/*求蒸汽流量的隶属值ֵ*/
	public double getZQLLMembership(){
		calculate cal = new calculate();
		double ZQLL_L=0;
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("ZQLL")){
				ZQLL_L= cal.LiShuZhi(MainDatas.get(0).getW_ZQLL(),
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
				//break;
			}
		}	
//		System.out.println("蒸汽流量的隶属值="+ZQLL_L);
		return ZQLL_L;
	}
	/*求给水流量的平均值ֵ*/
	public double getZQLL_PJZ(){
		double ZQLLPJZ=0;
		for(int j=0;j<MainDatas.size();j++)
			ZQLLPJZ+=MainDatas.get(0).getW_ZQLL();
		ZQLLPJZ=ZQLLPJZ/MainDatas.size()-1;
		return ZQLLPJZ;
		}
	/*求给水流量增大的隶属值ֵ*/
	public double getGSLLMembership(){
		calculate cal = new calculate();
		double GSLL_L=0;
		if(MainDatas.get(0).getW_GSLL()<MainDatas.get(MainDatas.size()-1).getW_GSLL())
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("GSLL")){
				GSLL_L= cal.LiShuZhi(MainDatas.get(MainDatas.size()-1).getW_GSLL()-MainDatas.get(0).getW_GSLL(),
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
				//break;
			}
		}	
//		System.out.println("给水流量的隶属值="+GSLL_L);
		return GSLL_L;
	}
	/*求给水流量的平均值ֵ*/
	public double getGSLL_PJZ(){
	double GSLLPJZ=0;
	for(int j=0;j<MainDatas.size();j++)
		GSLLPJZ+=MainDatas.get(0).getW_GSLL();
	GSLLPJZ=GSLLPJZ/MainDatas.size()-1;
	return GSLLPJZ;
	}
	/*求给水温度的隶属值ֵ*/
	public double getGSWDMembership(){
		calculate cal = new calculate();
		double GSWD_L=0;
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("GSWD")){
				GSWD_L= cal.LiShuZhi(MainDatas.get(0).getW_GSWD(),
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
			//	break;
			}
		}
//		System.out.println("给水温度的隶属值="+GSWD_L);
		return GSWD_L;
	}
	/*求给水压力增加的隶属值ֵ*/
	public double getGSYLMembership(){
		calculate cal = new calculate();
		double GSYL_L=0;
		if(MainDatas.get(MainDatas.size()-1).getW_GSYL()>MainDatas.get(0).getW_GSYL())
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("GSYL")){
				GSYL_L= cal.LiShuZhi(
			MainDatas.get(MainDatas.size()-1).getW_GSYL()-MainDatas.get(0).getW_GSYL(),
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
				//break;
			}
		}	
//		System.out.println("给水压力的隶属值="+GSYL_L);
		return GSYL_L;
	}	
	/*求排烟温度下降的隶属值ֵ*/
	public double getPYWDMembership(){
		calculate cal = new calculate();
		double PYWD_L=0;
		if(MainDatas.get(MainDatas.size()-1).getW_PYWD()<MainDatas.get(0).getW_PYWD())
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("PYWD")){
				PYWD_L= cal.LiShuZhi(MainDatas.get(0).getW_PYWD()-MainDatas.get(MainDatas.size()-1).getW_PYWD(),
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
				//break;
			}
		}
//		System.out.println("排烟温度的隶属值="+PYWD_L);
		return PYWD_L;
	}	
	/*求省煤器进出口水温偏差大的隶属值ֵ*/
	public double getSMQJCKSWMembership(){
		calculate cal = new calculate();
		double SMQCKSW_L=0;
		double k=0,k1=0;
		for(int i=0;i<MainDatas.size();i++)
			k=+MainDatas.get(i).getW_SMQCKSW();
		k=k/MainDatas.size();
		for(int i=0;i<MainDatas.size();i++)
			k1=+MainDatas.get(i).getW_SMQJKSW();
		k1=k1/MainDatas.size();
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("SMQCKSW")){
				SMQCKSW_L= cal.LiShuZhi(k-k1,
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
			//	break;
			}
		}
//		System.out.println("省煤器出口水温的隶属值="+SMQCKSW_L);
		return SMQCKSW_L;
	}	
	/*求省煤器进口水温的隶属值ֵ*/
	public double getSMQJKSWMembership(){
		calculate cal = new calculate();
		double SMQCKSW_L=0;
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("SMQCKSW")){
				SMQCKSW_L= cal.LiShuZhi(MainDatas.get(0).getW_SMQCKSW(),
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
			//	break;
			}
		}
//		System.out.println("省煤器出口水温的隶属值="+SMQCKSW_L);
		return SMQCKSW_L;
	}	
	/*求炉膛压力上升的隶属值ֵ*/
	public double getLTYLMembership(){
		calculate cal = new calculate();
		double LTYL_L=0;
		if(MainDatas.get(0).getW_LTYL()<MainDatas.get(MainDatas.size()-1).getW_LTYL())
			for(int j=0;j<con.size();j++){
				if(con.get(j).getPareName().equals("LTYL_UP")){
				LTYL_L= cal.LiShuZhi(
					MainDatas.get(MainDatas.size()-1).getW_LTYL()-MainDatas.get(0).getW_LTYL(),
					con.get(j).getFunCF(),
					con.get(j).getMaxValue(), 
					con.get(j).getMinValue());
					//break;
				}
				
	//		System.out.println("炉膛压力的隶属值="+LTYL_L);
		}
			return LTYL_L;
		
	}
	/*求汽包压力低的隶属ֵ*/
	public double getQBYLMembership(){
		calculate cal = new calculate();
		double QBYL_L=0;
		double k=0;
		for(int i=0;i<MainDatas.size();i++)
			k+=MainDatas.get(i).getW_QBYL();
		k=k/MainDatas.size();
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("QBYL_DI")){
				QBYL_L= cal.LiShuZhi(k,
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
				//break;
			}
		}	
//		System.out.println("汽包液位的隶属值="+QBYL_L);
		return QBYL_L;
	}
	/*求汽包压力下降的隶属ֵ*/
	public double getQBYLXJMembership(){
		calculate cal = new calculate();
		double QBYL_L=0;
	if(MainDatas.get(0).getW_QBYL()-MainDatas.get(MainDatas.size()-1).getW_QBYL()>0)
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("QBYL_DI")){
				QBYL_L= cal.LiShuZhi(MainDatas.get(0).getW_QBYL()-MainDatas.get(MainDatas.size()-1).getW_QBYL(),
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
				//break;
			}
		}	
//		System.out.println("汽包液位的隶属值="+QBYL_L);
		return QBYL_L;
	}
	public double getQBSW_UPMembership(){
		calculate cal = new calculate();
		double QBSW_L=0;
		double k=0;
		for(int i=0;i<MainDatas.size();i++)
			k+=MainDatas.get(i).getW_QBSW();
		k=k/MainDatas.size();
		for(int j=0;j<con.size();j++){
			if(con.get(j).getPareName().equals("QBSW_BIG")){
				QBSW_L= cal.LiShuZhi(k,
				con.get(j).getFunCF(),
				con.get(j).getMaxValue(), 
				con.get(j).getMinValue());
				//break;
			}
		}
			return QBSW_L;
		}	
	/*求汽包水位下降的隶属值*/
	public double getQBSWMembership(){
		calculate cal = new calculate();
		double QBSW_L=0;
		double W_QBSW=0;
		System.out.println(MainDatas.size()+"jds");
		if(MainDatas.get(0).getW_QBSW()<MainDatas.get(MainDatas.size()-1).getW_QBSW())
		{
			for(int j=0;j<con.size();j++){
				if(con.get(j).getPareName().equals("QBSW_XJ")){
					QBSW_L= cal.LiShuZhi(MainDatas.get(
							0).getW_QBSW()-MainDatas.get(MainDatas.size()-1).getW_QBSW(),
							con.get(j).getFunCF(),
							con.get(j).getMaxValue(), 
							con.get(j).getMinValue());
					//break;
				}
			
					}	
				}
			
//		System.out.println("汽包水位的隶属值="+QBSW_L);
		return QBSW_L;
	}
	/*求汽包水位上升的隶属值*/
	public double getQBSW_upMembership(){
		calculate cal = new calculate();
		double QBSW_L=0;
		double W_QBSW=0;
		if(MainDatas.get(0).getW_QBSW()>MainDatas.get(MainDatas.size()-1).getW_QBSW())
			for(int j=0;j<con.size();j++){
				if(con.get(j).getPareName().equals("QBSW_SS")){
					QBSW_L= cal.LiShuZhi(MainDatas.get(MainDatas.size()-1).getW_QBSW()-MainDatas.get(0).getW_QBSW(),
							con.get(j).getFunCF(),
							con.get(j).getMaxValue(), 
							con.get(j).getMinValue());
					//break;
			
					}	
				}
			
//		System.out.println("汽包水位的隶属值="+QBSW_L);
		return QBSW_L;
	}
	/*求给水流量与蒸汽流量偏差大的隶属值*/
	public double getPCDMembership(){//
	//	each.getGSLL_PJZ()-each.getGSLL_PJZ()
		calculate cal = new calculate();
		double PCD_L;
		for(int j=0;j<con.size();j++)
		{
			if(con.get(j).getPareName().equals("PCD_L")){
				PCD_L= cal.LiShuZhi(
						MainDatas.get(0).getW_QBSW()-MainDatas.get(MainDatas.size()-1).getW_QBSW(),
						con.get(j).getFunCF(),
						con.get(j).getMaxValue(), 
						con.get(j).getMinValue());
				}
		
		}
		return 0;
	}
}

