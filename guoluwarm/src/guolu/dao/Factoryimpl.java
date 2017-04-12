package guolu.dao;
/**
 * 通过如下类创建不同的dao接口的实现类。
 * 想要什么类的实例只需要传递此类的字符串类名即可。
 * @author RBB
 *
 */
public class Factoryimpl{
	/**
	 * 不需要创建对象
	 */
	private Factoryimpl(){}
	/**
	 * 获得对象
	 * @param type
	 * @return
	 */
	public static Object getInstance(String type){
		Object obj=null;
		if("LoginDAOimpl".equals(type)){
			obj=new LoginDAOimpl();
		}else if("RegisterDAOimpl".equals(type)){
			obj=new RegisterDAOimpl();
		}else if("UserDAOimpl".equals(type)){
			obj=new UserDAOimpl();
		}else if("FaultDAOimpl".equals(type)){
			obj=new FaultDAOimpl();
		}else if("SuggestDAOimpl".equals(type)){
			obj=new SuggestDAOimpl();
		}else if("MaintainDAOimpl".equals(type)){
			obj=new MaintainDAOimpl();
		}else if("WarnDAOimpl".equals(type)){
			obj=new WarnDAOimpl();
		}else{
			
		}
		return obj;
	}

}
