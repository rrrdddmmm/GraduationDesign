package com.xkd.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Db {
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
}
