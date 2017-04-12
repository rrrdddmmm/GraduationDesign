package guolu.service;

import guolu.accdata.GetPageData;
import guolu.dao.Factoryimpl;
import guolu.dao.FaultDAOimpl;
import guolu.entity.Accsholist;
import guolu.entity.Machinefaultmodal;
import guolu.entity.Showlistmodal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 实现falutlist.jsp页面的数据显示以及分页的功能
 * @author RBB
 *
 */
public class FaultPageListService {
	public static final int perPageRows=3;
	//一页显示的数据量
	public static Showlistmodal service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Accsholist mod=GetPageData.getdata(request, response);
		//获取传来的参数
		Showlistmodal modul = null;//将给页面显示的数据包对象
		if("模糊查询".equals(mod.getName())){
		}else if(mod.getName()!=null){
			//从dao.imp组件中将锅炉本体数据拿取过来转发给view层的Showlist.jsp
			FaultDAOimpl Fault=(FaultDAOimpl)(Factoryimpl.getInstance("FaultDAOimpl"));
			//利用工场创建逻辑处理对象
			try {
				//获取总的页数
				int allpage=Fault.Allpage(perPageRows,mod.getName());
				//显示第二页
				if(mod.getPage()!=null && mod.getPage().equals("two")){
				//判断第二页是否存在问题	
					if(allpage>=2){
						//第二页存在正常跳转到第三页
						modul=findPageAllData(2, perPageRows, mod.getName());
					}else{
						//第二页不存在跳转到最后一页
						modul=findPageAllData(allpage,perPageRows , mod.getName());
					}
					//显示第三页
				}else if(mod.getPage()!=null && mod.getPage().equals("tree")){
					//判断第三页是否存在问题	
					if(allpage>=3){
						//第三页存在正常跳转到第三页
						modul=findPageAllData(3, perPageRows, mod.getName());
					}else{
						//第三页不存在跳转到最后一页
						modul=findPageAllData(allpage,perPageRows , mod.getName());
					}
				}else if(mod.getPage()==null || Integer.parseInt(mod.getPage())<=1){
					//如果返回值为null说明是首次进入此界面则初始化为第一页，如果翻页翻到越界则赋值为1
					modul=findPageAllData(1, perPageRows, mod.getName());//页数，每页显示记录数，表名
					//将数据打包
				}else if(Integer.parseInt(mod.getPage())>=allpage){
					//如果翻页越上界则默认翻到最后一页
					modul=findPageAllData(allpage,perPageRows , mod.getName());
				}else{
					//上下界都不越则取传来的参数作为页数
					modul=findPageAllData(Integer.parseInt(mod.getPage()),perPageRows , mod.getName());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//throw new ServletException("连接数据库错误！！");
			}
		}else{
			System.out.println(mod.getName());
			System.out.println(mod.getPage());
			System.out.println("错误！");
			/**
			 * 为什么不跳转到错误处理页面
			 */
			throw new ServletException("获取参数出错!");
		}
		return modul;
	}
	/**
	 * 实现将表名、数据集(2条记录)、当前页、总页数打包数据包构成一个页面服务的数据
	 * 应该服务层来做
	 */
	public static Showlistmodal findPageAllData(int Pags,int perPageRows, String tablename)
			throws SQLException {
		// TODO Auto-generated method stub
		Showlistmodal modul=new Showlistmodal();
		FaultDAOimpl Fault=(FaultDAOimpl)(Factoryimpl.getInstance("FaultDAOimpl"));
		//存放着查询的数据
		List<Machinefaultmodal> list=Fault.findPagedata(Pags, perPageRows, tablename);
		int allpage=Fault.Allpage(perPageRows, tablename);
		modul.setCurrentPage(Pags);
		modul.setList(list);
		modul.setAllpage(allpage);
		modul.setTable_name(tablename);
		return modul;
	}
	/**
	 * 实现根据表名、列名查找一条数据的服务：
	 * 从页面接收参数，调用dao层的方法将接受的参数传进入的到想要的一条记录的结果，将数据返回给控制层。
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException 
	 */
	public static Machinefaultmodal FaultShowService(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String tablename=request.getParameter("tablename");
		String faultnumber=request.getParameter("faultnumber");
		FaultDAOimpl Fault=(FaultDAOimpl)(Factoryimpl.getInstance("FaultDAOimpl"));
		Machinefaultmodal modal =Fault.findonedata(tablename, faultnumber);
		return modal;
	}	
}
