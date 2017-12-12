package test.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class convert {
	//工具文件夹路径  
    public static String SWFTOOLS_PATH="C:/Program Files/SWFTools/";       
    public static int convertPDF2SWF(String sourcePath, String destPath, String fileName) throws IOException{  
  
  
        File dest = new File(destPath);       
        if (!dest.exists()) {       
            dest.mkdirs();       
        }       
      
        File source = new File(sourcePath);       
        if (!source.exists()) {       
            return -1;       
        }       
        //pdf转成swf  
        String[] envp = new String[1];       
        envp[0] = "PATH="+SWFTOOLS_PATH; //使用的工具路径      
        String command = "cmd /c \""+SWFTOOLS_PATH+"pdf2swf\" -z -s flashversion=9 " + sourcePath + " -o " + destPath + fileName ;       
        Process pro = Runtime.getRuntime().exec(command, envp);       
           
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(pro.getInputStream()));       
        while (bufferedReader.readLine() != null) {       
        }      
        try {       
            pro.waitFor();       
        } catch (InterruptedException e) {       
            e.printStackTrace();       
        }
        System.out.println("ddddd");     
        return pro.exitValue();  
    }  
}
