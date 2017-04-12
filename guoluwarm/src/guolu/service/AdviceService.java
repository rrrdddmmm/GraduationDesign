package guolu.service;

import java.io.IOException;
import java.sql.SQLException;

import guolu.accdata.GetAdviceData;
import guolu.accdata.GetAdviceInsData;
import guolu.accdata.GetPageAdviceData;
import guolu.dao.Factoryimpl;
import guolu.dao.FaultDAOimpl;
import guolu.dao.SuggestDAOimpl;
import guolu.entity.Adviceinfolistmodul;
import guolu.entity.Adviceinfomodal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdviceService {
	public static final int perPageRows=3;
/**
 * 建议接收服务
 * @param request
 * @param response
 * @return
 * @throws ServletException
 * @throws IOException
 * @throws SQLException
 */
	public static boolean service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		//获取数据
		Adviceinfomodal modul=GetAdviceData.getdata(request, response);
		//连接数据库实现数据库的写入
		SuggestDAOimpl suggest=(SuggestDAOimpl) Factoryimpl.getInstance("SuggestDAOimpl");
		if(true==suggest.addinfor(modul)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 实现建议显示翻页
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static Adviceinfolistmodul servicePageshow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		//获取数据，需要的页数，falge：故障建议还是维修保养知识建议
		Adviceinfolistmodul Adicelist=GetPageAdviceData.getdata(request, response);
		//连接数据库实现数据库的写入
		SuggestDAOimpl suggest=(SuggestDAOimpl) Factoryimpl.getInstance("SuggestDAOimpl");
		//获取总的页数
		int allpage=suggest.Allpage(perPageRows, Adicelist.getFlag());
		Adicelist.setAllpage(allpage);
		//显示第二页
		if(Adicelist.getCurrentPage()==2){
		//判断第二页是否存在问题	
			if(allpage>=2){
				//第二页存在正常跳转到第二页
				Adicelist.setModul(suggest.findPagedata(2, perPageRows, Adicelist.getFlag()));
			}else{
				//第二页不存在跳转到最后一页
				Adicelist.setModul(suggest.findPagedata(allpage, perPageRows, Adicelist.getFlag()));
			}
			//显示第三页
		}else if(Adicelist.getCurrentPage()==3){
			//判断第三页是否存在问题	
			if(allpage>=3){
				//第三页存在正常跳转到第三页
				Adicelist.setModul(suggest.findPagedata(3, perPageRows, Adicelist.getFlag()));
			}else{
				//第三页不存在跳转到最后一页
				Adicelist.setModul(suggest.findPagedata(allpage, perPageRows, Adicelist.getFlag()));
				Adicelist.setCurrentPage(allpage);
			}
		}else if(Adicelist.getCurrentPage()<=1){
			//如果返回值为null说明是首次进入此界面则初始化为第一页，如果翻页翻到越界则赋值为1
			Adicelist.setModul(suggest.findPagedata(1, perPageRows, Adicelist.getFlag()));
			Adicelist.setCurrentPage(1);
			//将数据打包
		}else if(Adicelist.getCurrentPage()>=allpage){
			//如果翻页越上界则默认翻到最后一页
			Adicelist.setModul(suggest.findPagedata(allpage, perPageRows, Adicelist.getFlag()));
			Adicelist.setCurrentPage(allpage);
		}else{
			//上下界都不越则取传来的参数作为页数
			Adicelist.setModul(suggest.findPagedata(Adicelist.getCurrentPage(), perPageRows, Adicelist.getFlag()));
		}
		return Adicelist ;
	}
	public static boolean Altoneservice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		//获取数据
		Adviceinfomodal modul=GetAdviceInsData.getdata(request, response);
		//连接数据库实现数据库的写入SuggestDAOimpl
		FaultDAOimpl imp=(FaultDAOimpl) Factoryimpl.getInstance("FaultDAOimpl");
		SuggestDAOimpl sugg=(SuggestDAOimpl) Factoryimpl.getInstance("SuggestDAOimpl");
		String Sql="UPDATE "+modul.getTablename()+" SET  falut_handle='"+modul.getText()+"' " +
		"WHERE falut_Number = '"+modul.getNumber()+"'";
		if(modul.getTablename()!=null && modul.getTablename().startsWith("boiler")){
			Sql="UPDATE "+modul.getTablename()+" SET  inspect_content='"+modul.getText()+"' " +
			"WHERE inspect_number = '"+modul.getNumber()+"'";
		}
		//对数据表进行修改成功，且对状态表修改成功才提示成功
		if(imp.alterone(Sql) && sugg.alteroneinfor(modul)){
			return true;
		}else{
			return false;
		}
	}
}
