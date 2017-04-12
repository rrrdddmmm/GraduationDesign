package guolu.dao;

public class DAOException extends Exception{

	/**
	 * 自定义异常类
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 目的：在创建此exception的时候可以指明一个异常的信息，以及哪一个异常引起了此异常
	 * 
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable cause) {
		//Throwable异常的父类  message异常的信息
		 
		
	}
}
