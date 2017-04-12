package guolu.service;

import guolu.accdata.GetPageData;
import guolu.dao.Factoryimpl;
import guolu.dao.MaintainDAOimpl;
import guolu.entity.Accsholist;
import guolu.entity.Machinemtmodal;
import guolu.entity.Showmainlistmodal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaintainPageListService {
	public static final int perPageRows=3;
	//一页显示的数据量
	public static Showmainlistmodal service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Accsholist mod=GetPageData.getdata(request, response);
		//获取传来的参数
		Showmainlistmodal modul = null;//将给页面显示的数据包对象
		if(mod.getName()!=null){
			//从dao.imp组件中将锅炉本体数据拿取过来转发给view层的list
			MaintainDAOimpl Fault=(MaintainDAOimpl)(Factoryimpl.getInstance("MaintainDAOimpl"));
			//利用工场创建逻辑处理对象
			try {
				//获取总的页数
				int allpage=Fault.Allpage(perPageRows,mod.getName(),mod.getT());
				//显示第二页
				if(mod.getPage()!=null && mod.getPage().equals("two")){
				//判断第二页是否存在问题	
					if(allpage>=2){
						//第二页存在正常跳转到第三页
						modul=findPageAllData(2, perPageRows, mod.getName(),mod.getT());
					}else{
						//第二页不存在跳转到最后一页
						modul=findPageAllData(allpage,perPageRows , mod.getName(),mod.getT());
					}
					//显示第三页
				}else if(mod.getPage()!=null && mod.getPage().equals("tree")){
					//判断第三页是否存在问题	
					if(allpage>=3){
						//第三页存在正常跳转到第三页
						modul=findPageAllData(3, perPageRows, mod.getName(),mod.getT());
					}else{
						//第三页不存在跳转到最后一页
						modul=findPageAllData(allpage,perPageRows , mod.getName(),mod.getT());
					}
				}else if(mod.getPage()==null || Integer.parseInt(mod.getPage())<=1){
					//如果返回值为null说明是首次进入此界面则初始化为第一页，如果翻页翻到越界则赋值为1
					modul=findPageAllData(1, perPageRows, mod.getName(),mod.getT());//页数，每页显示记录数，表名
					//将数据打包
				}else if(Integer.parseInt(mod.getPage())>=allpage){
					//如果翻页越上界则默认翻到最后一页
					modul=findPageAllData(allpage,perPageRows , mod.getName(),mod.getT());
				}else{
					//上下界都不越则取传来的参数作为页数
					modul=findPageAllData(Integer.parseInt(mod.getPage()),perPageRows , mod.getName(),mod.getT());
				}
			} catch (SQLException e) {
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
	 * 应该服务层来做。
	 * 点击班检是返回cycle=1、点击日检是返回cycle=2、
	 * 点击周检是返回cycle=3、点击月检是返回cycle=4、
	 * 点半年班检是返回cycle=5、点击年检是返回cycle=6
	 */
	public static Showmainlistmodal findPageAllData(int Pags,int perPageRows, String tablename,String cycle)
			throws SQLException {
		Showmainlistmodal modul=new Showmainlistmodal();
		MaintainDAOimpl Maindual=(MaintainDAOimpl)(Factoryimpl.getInstance("MaintainDAOimpl"));
		//存放着查询的数据
		List<Machinemtmodal> list=Maindual.findPagedata(Pags, perPageRows, tablename,cycle);
		int allpage=Maindual.Allpage(perPageRows, tablename,cycle);
		modul.setCurrentPage(Pags);
		modul.setList(list);
		modul.setAllpage(allpage);
		modul.setTable_name(tablename);
		modul.setCycle(cycle);
		return modul;
	}
}
