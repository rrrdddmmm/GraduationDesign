package test.test1;

import java.io.File;
import java.io.FileNotFoundException;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

//ת���ĵ�Ϊpdf
public class OpenOfficePdfConvert {

	/**
	 * @param args
	 */
	private static OfficeManager officeManager;
	private static String OFFICE_HOME = "C:\\Program Files\\OpenOffice.org 3";
	private static int port[] = { 8100 };
    
	public void convert2PDF(String inputFile, String outputFile) throws FileNotFoundException {
	    String fileName = null;
	    
	    /* 1  ����ת�� ����
	     * 2 start service
	     * 3 deal  tranlate
	     * 3 stop service
	     */
	    String fileName1 = inputFile.substring(0, inputFile.lastIndexOf("."));
	    if(inputFile.endsWith("txt")){
	    	String odtFile = fileName1+".odt";
	    	if(new File(odtFile).exists()){
	    		System.out.println("odt�ļ��Ѵ��ڣ�");
	    		inputFile = odtFile;
	    	}else{
                FileUtil.copyFile(inputFile, odtFile);
	    		inputFile = odtFile;
	    	}
	    }
		startService();
		System.out.println("�����ĵ�ת��ת��:" + inputFile + " --> " + outputFile);
		OfficeDocumentConverter converter = new OfficeDocumentConverter(
				officeManager);
		converter.convert(new File(inputFile), new File(outputFile));
		stopService();
		System.out.println();

	}

	// �򿪷�����
	public static void startService() {
		DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
		try {
			System.out.println("׼����������....");
			configuration.setOfficeHome(OFFICE_HOME);// ����OpenOffice.org��װĿ¼
			configuration.setPortNumbers(port); // ����ת���˿ڣ�Ĭ��Ϊ8100
			configuration.setTaskExecutionTimeout(1000 * 60 * 5L);// ��������ִ�г�ʱΪ5����
			configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);// ����������г�ʱΪ24Сʱ

			officeManager = configuration.buildOfficeManager();
			officeManager.start(); // ��������
			System.out.println("officeת�����������ɹ�!");
		} catch (Exception ce) {
			System.out.println("officeת����������ʧ��!��ϸ��Ϣ:" + ce);
		}
	}

	// �رշ�����
	public static void stopService() {
		System.out.println("�ر�officeת������....");
		if (officeManager != null) {
			officeManager.stop();
		}
		System.out.println("�ر�officeת���ɹ�!");
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
