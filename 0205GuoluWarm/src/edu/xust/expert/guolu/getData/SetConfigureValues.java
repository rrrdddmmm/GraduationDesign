package edu.xust.expert.guolu.getData;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;
import java.util.List;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.entity.Configure;

public class SetConfigureValues {
     
	public List<Configure> setconfigureValues(String sql){
		List<Configure> cfg = new ArrayList<Configure>();
		ResultSet rs =MyDB.executeQuerySql(sql);
		try {
			while(rs.next()){
				Configure cf = new Configure();
				cf.setPareName(rs.getString("PareName"));
				cf.setFunCF(rs.getInt("FunCF"));
				cf.setMaxValue(rs.getDouble("MaxValue"));
				cf.setMinValue(rs.getDouble("MinValue"));
				cfg.add(cf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return cfg;
	}
}
