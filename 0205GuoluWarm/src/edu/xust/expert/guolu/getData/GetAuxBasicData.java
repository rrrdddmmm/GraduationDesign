package edu.xust.expert.guolu.getData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.xust.db.MyDB;
import edu.xust.expert.guolu.entity.AuxBasicData;

public class GetAuxBasicData {
	public List<AuxBasicData> getAuxBasicData(String sql){
		List<AuxBasicData> bsd = new ArrayList<AuxBasicData>();
		ResultSet rs =MyDB.executeQuerySql(sql);	
		try {
			while(rs.next()){
				AuxBasicData bd = new AuxBasicData();
				bd.setGuoLuNum(rs.getInt("GUOLUNUM"));
				bd.setW_CJSJ(rs.getString("CJSJ"));
				bd.setW1_SBSDGD(rs.getDouble("SBSDGD1"));
				bd.setW1_SBYXSD(rs.getDouble("SBYXSD1"));
				bd.setW1_SBYXDL(rs.getDouble("SBYXDL1"));
				bd.setW2_SBSDGD(rs.getDouble("SBSDGD2"));
				bd.setW2_SBYXSD(rs.getDouble("SBYXSD2"));
				bd.setW2_SBYXDL(rs.getDouble("SBYXDL2"));
				bd.setW_YFJSDGD(rs.getDouble("YFJSDGD"));
				bd.setW_YFJYXDL(rs.getDouble("YFJYXDL"));
				bd.setW_YFJYXSD(rs.getDouble("YFJYXSD"));
				bd.setW_GFJSDGD(rs.getDouble("GFJSDGD"));
				bd.setW_GFJYXDL(rs.getDouble("GFJYXDL"));
				bd.setW_GFJYXSD(rs.getDouble("GFJYXSD"));
				bd.setState(rs.getInt("State"));
				bsd.add(bd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return bsd;	
	}
}
