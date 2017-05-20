package graduationDesignBackstage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Db恢复 {
	/**
	 * 有问题
	 * 
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		load1();
		// load2();

	}

	public static void load1() {
		try {
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime
					.exec("E:/MySQL Server 5.5/bin/mysql.exe -hlocalhost -uroot -p123456 --default-character-set=utf8 "
							+ "simulation_laboratory");
			OutputStream outputStream = process.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
					"F:/resource/db/20170520164155.sql"), "utf8"));
			String str = null;
			StringBuffer sb = new StringBuffer();
			while ((str = br.readLine()) != null) {
				sb.append(str + "\r\n");
			}
			str = sb.toString();
			System.out.println(str);
			OutputStreamWriter writer = new OutputStreamWriter(outputStream, "utf8");
			writer.write(str);
			writer.flush();
			outputStream.close();
			br.close();
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void load2() {
		try {
			String fPath = "F:/resource/db/simulation_laboratory.sql";
			Runtime rt = Runtime.getRuntime();
			// 调用 mysql 安装目录的命令
			Process child = rt
					.exec("mysql -h localhost -uroot -p123456 --default-character-set=utf8 simulation_laboratory");
			OutputStream out = child.getOutputStream();// 控制台的输入信息作为输出流
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fPath), "utf8"));
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
			writer.write(outStr);
			writer.flush();
			out.close();
			br.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
