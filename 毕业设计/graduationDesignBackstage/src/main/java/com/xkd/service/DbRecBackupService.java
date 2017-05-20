package com.xkd.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xkd.dao.BaseDbbackupMapper;
import com.xkd.entity.BaseDbbackup;
import com.xkd.util.ConfigStr;
import com.xkd.util.DateDealwith;

@Service("dbRecBackupService")
@Scope("prototype")
public class DbRecBackupService implements Serializable {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	/**
	 * 数据库备份表
	 */
	@Resource(name = "baseDbbackupMapper")
	private BaseDbbackupMapper	baseDbbackupMapper;

	public List<BaseDbbackup> list() {
		return baseDbbackupMapper.selectByPrimaryKey(null);

	}

	public BaseDbbackup backup(BaseDbbackup baseDbbackup) {
		String sqlname = DateDealwith.getSHC() + ".sql";
		try {
			baseDbbackup.setBackuppath(ConfigStr.sqlPath + sqlname);
			baseDbbackup.setCreattime(DateDealwith.getCurrDate());
			baseDbbackup.setCreattimestr(DateDealwith.getCurrDateStr());
			baseDbbackup.setId(DateDealwith.getSHC());
			if (baseDbbackupMapper.insertSelective(baseDbbackup) > 0) {
				if (backuputil(ConfigStr.mysqlbinPath, ConfigStr.user, ConfigStr.pwd, ConfigStr.dbName,
						ConfigStr.sqlPath, sqlname)) {
					baseDbbackup.setState("0");
					baseDbbackup.setMsg("数据备份成功!");
				} else {
					baseDbbackup.setState("1");
					baseDbbackup.setMsg("数据备份失败!");
				}
			} else {
				baseDbbackup.setState("2");
				baseDbbackup.setMsg("数据备份失败!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return baseDbbackup;
	}

	public BaseDbbackup recover(BaseDbbackup baseDbbackup) {
		try {
			if (recoverutil(ConfigStr.mysqlbinPath, ConfigStr.ip, ConfigStr.user, ConfigStr.pwd, ConfigStr.dbName,
					baseDbbackup.getBackuppath())) {
				baseDbbackup.setState("0");
				baseDbbackup.setMsg("服务器端：数据恢复成功!");
				return baseDbbackup;
			} else {
				baseDbbackup.setState("1");
				baseDbbackup.setMsg("服务器端：数据恢复失败!");
				return baseDbbackup;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseDbbackup.setState("2");
		baseDbbackup.setMsg("服务器端：数据恢复失败!");
		return baseDbbackup;
	}

	private Boolean recoverutil(String mysqlbinPath, String ip, String user, String pwd, String dbName,
			String sqlPathName) throws IOException {
		try {
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("" + mysqlbinPath + "mysql.exe -h" + ip + " -u" + user + " -p" + pwd
					+ " --default-character-set=utf8 " + dbName);
			OutputStream outputStream = process.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlPathName), "utf8"));
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
			return true;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean backuputil(String mysqlbinPath, String user, String pwd, String dbName, String sqlPath,
			String sqlname) throws IOException {
		File fPath = new File(sqlPath + sqlname);
		try {
			if (!fPath.exists()) {
				fPath.createNewFile();
				Runtime rt = Runtime.getRuntime();
				Process child = rt.exec(mysqlbinPath + "mysqldump.exe -u" + user + " -p" + pwd + " " + dbName);
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
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
