package edu.xust.expert.guolu.getData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.entity.MainBasicData;

public class GetMainBasicDataValues {
	public List<MainBasicData> getMainBasicData(String sql){
		List<MainBasicData> bsd = new ArrayList<MainBasicData>();
		ResultSet rs =MyDB.executeQuerySql(sql);
		try {
			while(rs.next()){
				MainBasicData bd = new MainBasicData();
				bd.setGuoLuNum(rs.getInt("GUOLUNUM"));
				bd.setW_CJSJ(rs.getString("CJSJ"));
				bd.setW_ZQYL(rs.getDouble("ZQYL"));
				bd.setW_ZQYL(rs.getDouble("ZQWD"));
				bd.setW_GSLL(rs.getDouble("GSLL"));
				bd.setW_GSWD(rs.getDouble("GSWD"));
				bd.setW_GSYL(rs.getDouble("GSYL"));
				bd.setW_SMQCKSW(rs.getDouble("SMQCKSW"));
				bd.setW_SMQJKSW(rs.getDouble("SMQJKSW"));
				bd.setW_PYWD(rs.getDouble("PYWD"));
				bd.setW_LTYL(rs.getDouble("LTYL"));
				bd.setW_QBYL(rs.getDouble("QBYL"));
				bd.setW_QBSW(rs.getDouble("QBSW"));
				bd.setState(rs.getInt("State"));
				bsd.add(bd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return bsd;
	}

}
