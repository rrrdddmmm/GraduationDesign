package test.test1;

import java.io.File;
import java.io.FileNotFoundException;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

//转换文档为pdf
public class OpenOfficePdfConvert {

	/**
	 * @param args
	 */
	private static OfficeManager officeManager;
	private static String OFFICE_HOME = "C:\\Program Files\\OpenOffice.org 3";
	private static int port[] = { 8100 };
    
	public void convert2PDF(String inputFile, String outputFile) throws FileNotFoundException {
	    String fileName = null;
	    
	    /* 1  进行转换 操作
	     * 2 start service
	     * 3 deal  tranlate
	     * 3 stop service
	     */
	    String fileName1 = inputFile.substring(0, inputFile.lastIndexOf("."));
	    if(inputFile.endsWith("txt")){
	    	String odtFile = fileName1+".odt";
	    	if(new File(odtFile).exists()){
	    		System.out.println("odt文件已存在！");
	    		inputFile = odtFile;
	    	}else{
                FileUtil.copyFile(inputFile, odtFile);
	    		inputFile = odtFile;
	    	}
	    }
		startService();
		System.out.println("进行文档转换转换:" + inputFile + " --> " + outputFile);
		OfficeDocumentConverter converter = new OfficeDocumentConverter(
				officeManager);
		converter.convert(new File(inputFile), new File(outputFile));
		stopService();
		System.out.println();

	}

	// 打开服务器
	public static void startService() {
		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
		try {
			System.out.println("准备启动服务....");
			configuration.setOfficeHome(OFFICE_HOME);// 设置OpenOffice.org安装目录
			configuration.setPortNumbers(port); // 设置转换端口，默认为8100
			configuration.setTaskExecutionTimeout(1000 * 60 * 5L);// 设置任务执行超时为5分钟
			configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);// 设置任务队列超时为24小时

			officeManager = configuration.buildOfficeManager();
			officeManager.start(); // 启动服务
			System.out.println("office转换服务启动成功!");
		} catch (Exception ce) {
			System.out.println("office转换服务启动失败!详细信息:" + ce);
		}
	}

	// 关闭服务器
	public static void stopService() {
		System.out.println("关闭office转换服务....");
		if (officeManager != null) {
			officeManager.stop();
		}
		System.out.println("关闭office转换成功!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFile = "d:\\resource\\1.doc";
		String outputFile = "d:\\resource\\1.pdf";
		OpenOfficePdfConvert opc = new OpenOfficePdfConvert();
		try {
			opc.convert2PDF(inputFile, outputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
