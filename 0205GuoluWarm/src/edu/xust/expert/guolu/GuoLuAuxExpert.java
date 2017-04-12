package edu.xust.expert.guolu;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.db.MyDB;
import edu.xust.expert.Expert;
import edu.xust.expert.guolu.entity.AuxBasicData;
import edu.xust.expert.guolu.getData.GetAuxBasicData;

;

public class GuoLuAuxExpert implements Expert {//接口 implements
	private static Logger log = LoggerFactory.getLogger(GuoLuAuxExpert.class);
	GetAuxBasicData  GetAux= new GetAuxBasicData();
	//定义辅助设备数据的类的对象
	List<AuxBasicData>  AuxDatas;
	//定义接受辅助设备数据的集合
	@Override
	//方法的重写或函数的实现
	public void start() {
		// TODO Auto-generated method stub
		try {		
			String sql = "select  top 4  * from GL_AuxBasicData where  State=0  order by CJSJ desc";
			//获取数据的条件
			AuxDatas=GetAux.getAuxBasicData(sql);
			if(AuxDatas.size()>2){
				insert();	
				String update_state="update GL_AuxBasicData set State=0 where   State=1";		
				boolean flag= MyDB.executeSql(update_state);		
				log.info(flag?"辅助设备参数更新成功":"辅助设备参数更新失败");  //mei you shu ju 
			}else{
				log.info("辅助设备数据没有更新");  //mei you shu ju 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	//*********************辅助设备*****************************
	public int waterpump1(){
		int countsb=0;
		for(int i=0;i<AuxDatas.size();i++){
			if((AuxDatas.get(i).getW1_SBYXSD()-AuxDatas.get(i).getW1_SBSDGD())>10||(AuxDatas.get(i).getW1_SBYXDL()>10)){
				//人为设定速度差电流差；
				countsb++;
			}
		}
		return countsb;
	}
	
	public int waterpump2(){
		int countsb=0;
		for(int i=0;i<AuxDatas.size();i++){
			if((AuxDatas.get(i).getW2_SBYXSD()-AuxDatas.get(i).getW2_SBSDGD())>10||(AuxDatas.get(i).getW2_SBYXDL()>10)){
				//人为设定速度差电流差；
				countsb++;
			}
		}
		return countsb;
	}
	
	
	public int bellowfan(){
		int countbf=0;
		for(int i=0;i<AuxDatas.size();i++){
			if((AuxDatas.get(i).getW_GFJYXSD()-AuxDatas.get(i).getW_GFJSDGD())>10||(AuxDatas.get(i).getW_GFJYXDL()>10)){
					//人为设定速度差电流差；
				countbf++;
			}
		}
		return countbf;
	}
	
	public int  draftfan(){
		int countdf=0;
		for(int i=0;i<AuxDatas.size();i++){
			if((AuxDatas.get(i).getW_YFJYXSD()-AuxDatas.get(i).getW_YFJSDGD())>10||(AuxDatas.get(i).getW_YFJYXDL()>10))
			{
				//人为设定速度差，电流差；
			countdf++;
			}
		}
		return countdf;
	}
		
	public void insert(){
	//	int flag=waterpump1()==0?0:1;
		int flag=waterpump1()==10?1:0;
		String sql_waterpump1="insert into GL_OutPut(Name,Number,State)values('水泵故障',81,"+flag+")";
    	MyDB.executeSql(sql_waterpump1);
    	
    	int flag3=waterpump2()==0?0:1;
		String sql_waterpump2="insert into GL_OutPut(Name,Number,State)values('水泵故障',82,"+flag3+")";
    	MyDB.executeSql(sql_waterpump2);
    	
		
		int  flag1=bellowfan()==0?0:1;
	    String sql_bellowfan="insert into GL_OutPut(Name,Number,State)values('鼓风机故障',9,"+flag1+")";
		MyDB.executeSql(sql_bellowfan);
		
	    int  flag2=draftfan()==0?0:1;
		String sql_draftfan="insert into GL_OutPut(Name,Number,State)values('引风机故障',10,"+flag2+")";
		MyDB.executeSql(sql_draftfan);
	}
}
