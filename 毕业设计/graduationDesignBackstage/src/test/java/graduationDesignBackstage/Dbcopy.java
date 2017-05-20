package graduationDesignBackstage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.xkd.util.DateDealwith;

/**
 * 数据库备份测试
 * 
 * @author RBB
 *
 */
public class Dbcopy {
	public static void main(String args[]) throws IOException {
		String command = "E:/MySQL Server 5.5/bin/mysqldump.exe -uroot -p123456 simulation_laboratory";
		String f = "F:/resource" + "/db/" + DateDealwith.getSHC() + ".sql";
		File fPath = new File(f);
		if (!fPath.exists()) {
			fPath.createNewFile();
		}
		Runtime rt = Runtime.getRuntime();
		try {
			Process child = rt.exec(command);
			InputStream in = child.getInputStream();
			InputStreamReader input = new InputStreamReader(in, "utf8");
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(input);
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			FileOutputStream fout = new FileOutputStream(fPath);
			OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
			writer.write(outStr);
			writer.flush();
			in.close();
			input.close();
			br.close();
			writer.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("数据库备份成功");
	}
}
