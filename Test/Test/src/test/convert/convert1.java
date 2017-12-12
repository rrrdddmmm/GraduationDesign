package test.convert;

import java.io.File;
import java.net.ConnectException;


import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class convert1 {
	private File inputFile;// ��Ҫת�����ļ�
	private File outputFile;// ������ļ�

	public void docToPdf(File inputFile, File outputFile) {

		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8080);
		System.out.println(connection.isConnected());
		try {
			connection.connect();
			DocumentConverter converter = new OpenOfficeDocumentConverter(
					connection);
			converter.convert(inputFile, outputFile);
		} catch (ConnectException cex) {
			cex.printStackTrace();
		} finally {
			// close the connection
			if (connection != null) {
				connection.disconnect();
				connection = null;
			}
		}
	}

	/**
	 * ���ڷ������̲߳���ȫ�ģ����ԡ�����Ҫ�����߳�
	 */

	public File getInputFile() {
		return inputFile;
	}

	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	public File getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

	/**
	 * ����main����
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		File inputFile = new File("D://3.ppt");
		File outputFile = new File("c://3.pdf");
		convert1 c = new convert1();
		c.docToPdf(inputFile, outputFile);
	}
}