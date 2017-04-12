package guolu.dao;

import guolu.entity.GuoluSearchmodul;
import guolu.entity.Nanlaingdatamodal;
import guolu.entity.EvaluateResult;

import java.sql.SQLException;
import java.util.List;

public interface WarnDAO {
/**
 * 获取南梁锅炉主体设备时时数据存放在集合中
 * 时间和数据对应
 * @param modul
 * @return
 */
	public List<Nanlaingdatamodal> findnanliangdata(GuoluSearchmodul modul)throws SQLException;
	public List<Nanlaingdatamodal> findresultdata(EvaluateResult modul)throws SQLException;
}
