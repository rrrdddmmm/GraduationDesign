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
		     File sourceFile ;//ת��Դ�ļ� 
		     File pdfFile ;//pdf��ʽ�ļ�
		     File swfFile;//swf��ʽ�ļ�
		     String baseFile = null;//ת���ļ��ĵ�ַ
		     String pdf= null;//pdfת��
		     String swfn = null;
		     
		     sourceFile = new File(baseFile);
		     pdfFile  = new File(pdf);
		     swfFile = new File(swfn);
		     
		     
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 File sourceFile ;//ת��Դ�ļ� 
	     File pdfFile ;//pdf��ʽ�ļ�
	     File swfFile;//swf��ʽ�ļ�
	     sourceFile = new File("D:\\apache-tomcat-7.0.8\\webapps\\Test\\swf\\3.ppt");
	     pdfFile = new File("D:\\apache-tomcat-7.0.8\\webapps\\Test\\swf\\3.pdf");
	      swfFile = new File("D:\\apache-tomcat-7.0.8\\webapps\\Test\\swf\\3.swf");
	      System.out.println("��һ��ת��");
	      //ת��pdf
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
				    System.out.println("�ڶ�����ת��ΪPDF��ʽ·��"+pdfFile.getPath());
	    	      } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("office ������δ������");
				}catch(com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e){
				               e.printStackTrace();
				               System.out.println("��ȡ�ļ�ʧ��");
				} 
	    	  }else{
	    		  System.out.println("��Ҫת���ĸ�ʽ�Ѵ��ڣ�");
	    	  }
	      }else{
    		  System.out.println("��Ҫת����Դ�ļ������ڣ�");
    	  }
	}

}
