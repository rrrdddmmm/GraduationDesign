package test.action;

import java.io.File;

//实现文档格式的转换

public class convert1 {

	public static void main(String[] args) throws Exception {
		String exe = "D:\\SoCool\\FlashPrinter.exe";
		// File file = new File("D:\\apache-tomcat-7.0.8\\webapps\\resources");
		// String[] name = file.list();
		//
		// for (String name1 : name) {
		//
		// System.out.println(name1);
		// // 截取资源的名称
		// String beforeFile = name1.substring(0, name1.indexOf("."));
		// System.out.println();
		// // 截取的后缀名
		// String afterFile = name1.substring(name1.indexOf("."));
		// System.out.println(afterFile);
		// if (afterFile.equals(".txt") || afterFile.equals(".doc")
		// || afterFile.equals(".ppt") || afterFile.equals(".wps")
		// || afterFile.equals(".exl") || afterFile.equals(".docx")
		// || afterFile.equals(".pdf")) {
		// String fileSrc = "D:\\apache-tomcat-7.0.8\\webapps\\resources\\"
		// + name1;
		// String fileConv = "D:\\apache-tomcat-7.0.8\\webapps\\resources\\"
		// + beforeFile + ".swf";
		// Runtime.getRuntime().exec(
		// exe + " " + fileSrc + " -o " + fileConv);
		// System.out.println(name1);
		// }
		// }
		/*
		 * String basefile = "D:\\3.ppt"; String afterfile = "D:\\3.swf";
		 * Runtime.getRuntime().exec(exe+" "+ basefile + " -o " + afterfile);
		 * System.out.println("over");
		 */
		String basefile = "D:\\apache-tomcat-7.0.8\\webapps\\resources\\";
		String [] array = {"2.08有理数的除法.doc"};
		for(int i = 0 ;i<array.length;i++){
			String src = basefile+array[i];
			String s = array[i].substring(0,array[i].lastIndexOf("."));
			String afterfile = basefile+s+".swf";
			Runtime.getRuntime().exec(exe + " " + src + " -o " + afterfile);
			System.out.println("over"+i);
		}
//		String  file = "D:\\apache-tomcat-7.0.8\\webapps\\resources\\2.09有理数的除法.doc";
//		String afterfile = "D:\\apache-tomcat-7.0.8\\webapps\\resources\\2.09有理数的乘方.swf";
	
		
	}

}