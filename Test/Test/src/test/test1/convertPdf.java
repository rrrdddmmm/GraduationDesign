package test.test1;

import java.io.File;
import java.io.IOException;

//ת����swf��ʽ��
public class convertPdf {

	/**
	 * @param args
	 */
	private static String PDF2SWF_PATH = "C:\\Program Files\\SWFTools\\pdf2swf.exe";
	public void convertPDF(String inputFile, String outputFile) {
		   File pdfFile = new File(inputFile);
		   File swfFile = new File(outputFile);
		   if(!inputFile.endsWith(".pdf")){
			   System.out.println("�ļ���ʽ����pd");
		       return ; 
		   }
		   if(!pdfFile.exists()){
			   System.out.println("pdf�ļ��Ѵ��ڣ�");
		       return ;
		   }
		   if(swfFile.exists()){
			   System.out.println("swf�ļ��Ѵ��ڣ�");
		       return ;
		   }
		   //����ת��
		   try{
			   /*
			    * languagedir=D:\\xpdf-chinese-simplified  ���ڴ���pdfת��ʱ���ֵ�����
			    * ����pdfת����������Ҫ�������� 
			    * 1 ����XPDF��ftp://ftp.foolabs.com/pub/xpdf/xpdf-chinese-simplified.tar.gz ��ѹ�� D:\xpdf-chinese-simplified
                  2��������:http://blog.pjoke.com/wp-content/uploads/2009/02/font.zip ��ѹ��D:\xpdf-chinese-simplified\CMap\
                  3 ���ô򿪲��޸�xpdf-chinese-simplifiedĿ¼�µ�add-to-xpdfrc�ļ����������·����Ϊ�Լ���·����
			    */
		   String command = PDF2SWF_PATH +" \""+inputFile+"\" -o "+swfFile+" -T 9 -s languagedir=D:\\xpdf-chinese-simplified";
				System.out.println("��ʼת���ĵ�: "+inputFile);
				Runtime.getRuntime().exec(command);
				System.out.println("�ɹ�ת��ΪSWF�ļ���");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("ת���ĵ�Ϊswf�ļ�ʧ�ܣ�");
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
