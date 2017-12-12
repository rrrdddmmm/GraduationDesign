package test.convert;

import java.io.File;
import java.io.IOException;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;



public class convert {

	/**
	 * @param args
	 */
	public void converdocument(){
		     File sourceFile ;//转换源文件 
		     File pdfFile ;//pdf格式文件
		     File swfFile;//swf格式文件
		     String baseFile = null;//转换文件的地址
		     String pdf= null;//pdf转换
		     String swfn = null;
		     
		     sourceFile = new File(baseFile);
		     pdfFile  = new File(pdf);
		     swfFile = new File(swfn);
		     
		     
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 File sourceFile ;//转换源文件 
	     File pdfFile ;//pdf格式文件
	     File swfFile;//swf格式文件
	     sourceFile = new File("D:\\apache-tomcat-7.0.8\\webapps\\Test\\swf\\3.ppt");
	     pdfFile = new File("D:\\apache-tomcat-7.0.8\\webapps\\Test\\swf\\3.pdf");
	      swfFile = new File("D:\\apache-tomcat-7.0.8\\webapps\\Test\\swf\\3.swf");
	      System.out.println("第一步转换");
	      //转换pdf
	      if(sourceFile.exists()){
	    	  if(!pdfFile.exists()){
	    		  //open office
	    		  OpenOfficeConnection connection =  new SocketOpenOfficeConnection(8100);
	    	      //recieve  convert
	    		  try {
	    		  DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
	    	      converter.convert(sourceFile, pdfFile);
					pdfFile.createNewFile();
					connection.disconnect();
				    System.out.println("第二步：转换为PDF格式路径"+pdfFile.getPath());
	    	      } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("office 服务器未启动！");
				}catch(com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e){
				               e.printStackTrace();
				               System.out.println("读取文件失败");
				} 
	    	  }else{
	    		  System.out.println("你要转换的格式已存在！");
	    	  }
	      }else{
    		  System.out.println("你要转换的源文件不存在！");
    	  }
	}

}
