package test.convert;

import java.io.File;
import java.io.IOException;

public class convertPdf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File sourceFile;// ת��Դ�ļ�
		File pdfFile;// pdf��ʽ�ļ�
		File swfFile;// swf��ʽ�ļ�
		sourceFile = new File(
				"D:\\apache-tomcat-7.0.8\\webapps\\Test\\swf\\2.pdf");
		pdfFile = new File("D:\\apache-tomcat-7.0.8\\webapps\\Test\\swf\\2.pdf");
		swfFile = new File("D:\\apache-tomcat-7.0.8\\webapps\\Test\\swf\\2.swf");

		if (sourceFile.exists()) {
			try {
				Process p = Runtime.getRuntime().exec(
						"C:/Program Files/SWFTools/pdf2swf.exe"
								+ pdfFile.getPath() + " -o " + swfFile.getPath()
								+ " -T 9");
				System.out.println(pdfFile.getPath());
				       try {
						p.waitFor();
						swfFile.createNewFile();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
