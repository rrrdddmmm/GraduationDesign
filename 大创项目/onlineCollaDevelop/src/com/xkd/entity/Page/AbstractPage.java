package com.xkd.entity.Page;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xkd.entity.Entity;
import com.xkd.util.ConfigStr;
import com.xkd.util.FormatStr;

/**
 * 
 * 抽象翻页模型
 * 使用说明：
 * @author RBB
 *
 */
public abstract class AbstractPage implements ConfigStr{
	/**
	 * 翻页模型
	 */
	private Page page;
	private String flag="del";
	/**
	 * 分页查询查找指定页数的数据
	 * @Pags:要显示的当前页数，从第一页开始
	 * @param PagsAndRows：=perPageRows *(Pags-1)
	 * @param pageSize：每页记录数
	 * @return
	 */	
	public Map<String,Object> findPageData(Page page) throws SQLException{
		//输出子类的tostring方法，因为：父类指向子类，调用的是子类重写父类的tostring方法
		this.page=page;
		//设置总页数
		if(allRows(this.page)!=null){
			this.page.setRows(allRows(this.page));
		}else{
			this.page.setRows(0);
		}
		//如果是首次Pags的值将会=0
		this.page.setCurrentPage(page.getCurrentPage());
		if(this.page.getCurrentPage()!=0){
			this.page.setPagsAndRows(this.page.getPageSize()*(this.page.getCurrentPage()-1));//当前页不能小于等于0否则就会出现负数，sql会出现“-”附近有语法错误
		}else{
			this.page.setPagsAndRows(0);
		}
		//设置全部记录数
		if(getallRows()!=null){
			this.page.setAdd(getallRows());
		}else{
			this.page.setAdd(0);
		}
		//将页面要显示的list数据和翻页所需的数据放入map中通过控制器直接传入前台
		Map<String,Object> pagemap=new HashMap<String,Object>();
		//构造分页参数
		List<?> list=null;
		list = getPageList(this.page);
		//将list基本数据和翻页所需数据进行打包成一个map，发送给控制层后发送给页面
		pagemap.put(listdate, list);
		pagemap.put(pagedate, this.page);
		return pagemap;
	}
	/**
	 * 功能:获取全部实体数据，以集合的形式输出
	 * @return
	 */
	protected abstract List<?> getPageList(Page page)throws SQLException;
	/**
	 * 功能：获取具体业务的总行数
	 * @return
	 */
	protected abstract Integer allRows(Page page)throws SQLException;
	/**
	 * 功能：获取总行数，用于逆序分页
	 * @return
	 */
	protected Integer getallRows()throws SQLException{return 0;}
/**************************************************************************************/
/************************************批量删除和更新***************************************/	
	/**
	 * 批量删除保存:函数重载实现要是有字符串就是更新没有就是删除
	 * @param Str
	 * @return
	 */
	public boolean delAndUpdataSave(String Str)throws SQLException{
		return delAndUpdataSave(Str,flag);
	}
	/**
	 * 批量更新保存:函数重载实现要是有字符串就是更新没有就是删除
	 * @param Str
	 * @return
	 */
	public boolean delAndUpdataSave(String Str,String flag)throws SQLException{
		//创建一个list集合作为根据批量权限id值查找权限信息的参数
		List<String> List=null;
		if(Str!=null){
			//接收进来的数据进行处理成需要的格式
			List=FormatStr.ToListStr(Str, ",");
			if("del".equals(flag)){
					return delListData(List);
			}else{
					return updataListData(List);
			}
		}
		return false;
	}
	/**
	 * 批量删除，需要重写即可
	 * @param List:要传的参数
	 * @return
	 * @throws SQLException
	 */
	protected boolean delListData(List<?> List)throws SQLException{return false;};
	/**
	 * 批量更新，需要重写即可
	 * @param List
	 * @return
	 * @throws SQLException
	 */
	protected boolean updataListData(List<?> List)throws SQLException {return false;}
/**************************************************************************************/
/*************************************数据更新******************************************/

	/**
	 * 数据更新保存
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	protected boolean updataSave(Entity entity)throws SQLException {return false;}
/**************************************************************************************/
/*************************************数据查询*******************************************/
	/**
	 * 查询全部数据
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	protected Entity findAll()throws SQLException {return null;}
	/**
	 * 条件查询一条数据
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	protected Entity findByFactory(Entity entity)throws SQLException {return null;}
	/**
	 * 条件查询一列数据
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	protected List<?> findByFactoryList(Entity entity)throws SQLException {return null;}
/*************************************单个数据删除******************************************/
	/**
	 * 数据删除保存
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	protected boolean delSave(Entity entity)throws SQLException {return false;}
/*************************************添加数据******************************************/
	/**
	 * 添加一条数据
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	protected boolean addSave(Entity entity)throws SQLException {return false;}
	/**
	 * 添加一批数据
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	protected boolean addListSave(List<?> list)throws SQLException {return false;}
/**************************************************************************************/
/*************************************数据验证******************************************/
	/**
	 * 数据单个验证
	 */
	protected boolean verify(String factor)throws SQLException {return false;}
}








