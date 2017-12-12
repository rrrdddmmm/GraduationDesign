package test.test1;

import java.io.File;
import java.io.FileNotFoundException;

import test.test1.OpenOfficePdfConvert;
import test.test1.convertPdf;

public class convertDocument {

	/**
	 * @param args
	 */
	public static File file = new File("D:\\resource");
	public static String[] fileNames = file.list();
	public static String fileName = "D:\\resource\\";// ����·��
    //��һ���� ��wordת����pdf
	public static void convertPDF() {

		for (String name : fileNames) {
			System.out.println(name);
			String prefix = name.substring(name.lastIndexOf("."));// �ļ��ĺ�׺��
			System.out.println(prefix);
			String beforePrefix = name.substring(0, name.lastIndexOf("."));// �ļ�������
			if (prefix.equalsIgnoreCase(".txt")
					|| prefix.equalsIgnoreCase(".ppt")
					|| prefix.equalsIgnoreCase(".xls")
					|| prefix.equalsIgnoreCase(".xlsx")
					|| prefix.equalsIgnoreCase(".pptx")
					|| prefix.equalsIgnoreCase(".doc")
					|| prefix.equalsIgnoreCase(".docx")) {
				String inputFile = fileName + name;// ������Դ��·��
				String pdfFile = fileName + beforePrefix + ".pdf";// ���ñ���·��
				OpenOfficePdfConvert convert = new OpenOfficePdfConvert();
				try {
					convert.convert2PDF(inputFile, pdfFile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
    //�ڶ��� ��pdfת����swf
	public static void convertSWF() {
		convertPdf cp = new convertPdf();
		for (String name : fileNames) {
			System.out.println(name);
			String prefix = name.substring(name.lastIndexOf("."));// �ļ��ĺ�׺��
			System.out.println(prefix);
			String beforePrefix = name.substring(0, name.lastIndexOf("."));// �ļ�������
			if (prefix.equalsIgnoreCase(".pdf")) {
				String pdfFile = fileName + beforePrefix + ".pdf";
				String swfFile = fileName + beforePrefix + ".swf";
				cp.convertPDF(pdfFile, swfFile);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           convertPDF();
           convertSWF();
	}

}
