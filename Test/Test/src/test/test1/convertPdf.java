package test.test1;

import java.io.File;
import java.io.IOException;

//转换成swf格式的
public class convertPdf {

	/**
	 * @param args
	 */
	private static String PDF2SWF_PATH = "C:\\Program Files\\SWFTools\\pdf2swf.exe";
	public void convertPDF(String inputFile, String outputFile) {
		   File pdfFile = new File(inputFile);
		   File swfFile = new File(outputFile);
		   if(!inputFile.endsWith(".pdf")){
			   System.out.println("文件格式不是pd");
		       return ; 
		   }
		   if(!pdfFile.exists()){
			   System.out.println("pdf文件已存在！");
		       return ;
		   }
		   if(swfFile.exists()){
			   System.out.println("swf文件已存在！");
		       return ;
		   }
		   //进行转换
		   try{
			   /*
			    * languagedir=D:\\xpdf-chinese-simplified  用于处理pdf转换时出现的乱码
			    * 处理pdf转换的乱码需要进行三步 
			    * 1 下载XPDF：ftp://ftp.foolabs.com/pub/xpdf/xpdf-chinese-simplified.tar.gz 解压到 D:\xpdf-chinese-simplified
                  2下载字体:http://blog.pjoke.com/wp-content/uploads/2009/02/font.zip 解压到D:\xpdf-chinese-simplified\CMap\
                  3 配置打开并修改xpdf-chinese-simplified目录下的add-to-xpdfrc文件。将里面的路径设为自己的路径：
			    */
		   String command = PDF2SWF_PATH +" \""+inputFile+"\" -o "+swfFile+" -T 9 -s languagedir=D:\\xpdf-chinese-simplified";
				System.out.println("开始转换文档: "+inputFile);
				Runtime.getRuntime().exec(command);
				System.out.println("成功转换为SWF文件！");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("转换文档为swf文件失败！");
			}
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//           convertPdf c = new convertPdf();
//           String inputFile ="d:/resource/2.pdf";
//           String outputFile = "d:/4.swf";
//           c.convertPDF(inputFile,outputFile);
//	}

}
