package edu.xust.expert.guolu.getData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.entity.Condition;

public class SetConditionValues {
     /*
      * 连接数据库并取数据R_Condition，R_Result，R_CF
      * 取数据个规则"SELECT * FROM GL_confidence WHERE R_Result = '省煤器堵塞。。。。。。'";
      * 存入集合中
      */
	public List<Condition> setconditionValues(String sql){
		//String sql = "SELECT * FROM GL_confidence WHERE R_Result ='水冷凝壁泄漏'"; 
		//其他类似
		List<Condition> cdt = new ArrayList<Condition>();
		//定义集合,将每一对象cd对应的每一组对应的
		//R_Condition(征兆名),R_Result(结果名),R_CF(前提置信度)属性存放其中
		//类似结构体数组,或类的数组
		ResultSet rs =MyDB.executeQuerySql(sql);
		//连接数据库
		try {
			while(rs.next()){
				//接受数据
				Condition cd = new Condition();
				cd.setR_Condition(rs.getString("R_Condition"));
				cd.setR_Result(rs.getString("R_Result"));
				cd.setR_CF(rs.getDouble("R_CF"));
				cdt.add(cd);
				//添加集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return cdt;
		//返回此集合,以便以后调用
	}
}
