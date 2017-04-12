package guolu.util;

import java.util.List;
/**
 * 生成唯一编号工具类
 * @author RBB
 *
 */
public class DBUtil_number {

	public static String getuniqueNumber(List<String> list,String tablename){
		//当满足时再跳出来，否则一直找下去
		int num=0;
		int flag = 0;
		while(1==1){
			for(int i=0;i<list.size();i++){
				String str=list.get(i).substring(tablename.length());
				if(Integer.parseInt(str)==num){
					break;
				}
				flag=i;
			}
			if(flag+1==list.size()){
				//说明构造的这个编号可用不重复
				return tablename+num;
			}else{
				//说明构造的这个编号出现重复，应该重新生成编号
				num++;
			}	
		}
	}
	/**
	 * 为维修保养知识库新添加的知识产生唯一编号
	 * 根据因为不同表、不同周期而致使编号不同
	 * 在List<String> list中存放某某表的某某周期的所有编码，以便后期分析
	 * @param list
	 * @param tablename
	 * @param cycle
	 * @return
	 */
	public static String getmaintainNumber(List<String> list,String tablename,String cycle){
		return tablename;
		//当满足时再跳出来，否则一直找下去
		
	}
}
