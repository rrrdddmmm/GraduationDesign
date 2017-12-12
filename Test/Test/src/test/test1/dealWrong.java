package test.test1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class dealWrong {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            String PATH_TO_XPDF ="C:\\TDDOWNLOAD\\xpdf-chinese-simplified\\xpdf\\pdftotext.exe";
            String fileName = "d:\4.swf";
            String []cmd = new String[]{PATH_TO_XPDF,"-cfg","xpdfrc","-q",fileName,"-"};
            try {
				Process p = Runtime.getRuntime().exec(cmd);
				BufferedInputStream bis = new  BufferedInputStream(p.getInputStream());
				InputStreamReader reader = 	new InputStreamReader(bis,"UTF-8");
				int ch = 0 ;
				System.out.println("read pdf");
				while(ch==reader.read()){
					System.out.println((char)ch);
				}
				reader.close();
				System.out.println("read stop");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
  //deal with wrong when you tranlslate 
	

}
