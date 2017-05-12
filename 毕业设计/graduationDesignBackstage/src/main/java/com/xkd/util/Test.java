package com.xkd.util;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Test {

	/**
	 * @param args
	 * @throws XMLParserException
	 * @throws IOException
	 * @throws InvalidConfigurationException
	 * @throws InterruptedException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException,
			SQLException, InterruptedException {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// java -jar jar/mybatis-generator-core-1.3.5.jar -configfile
		// generatorConfig.xml -overwrite
		File configFile = new File(
				"D:\\git项目\\毕业设计\\graduationDesign\\src\\main\\webapp\\database\\mybatis-generator\\generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		// Configuration configuration = new
		// PropertiesConfiguration(ScriptRunnerExecSql.class.getClassLoader().getResource("")
		// + "META-INF/spring/db.properties");
		// String url = configuration.getString("jdbc.url");
		// String driver = configuration.getString("jdbc.driver");
		// String username = configuration.getString("jdbc.user");
		// String password = configuration.getString("jdbc.password");
		//
		// Class.forName(driver).newInstance();
		// Connection conn =(Connection) DriverManager.getConnection(url,
		// username, password);
		// ScriptRunner runner = new ScriptRunner(conn);
		// Resources.setCharset(Charset.forName("GBK")); //设置字符集,不然中文乱码插入错误
		// runner.setLogWriter(null);//设置是否输出日志
		// runner.runScript(Resources.getResourceAsReader("sql/CC20-01.sql"));
		// runner.runScript(Resources.getResourceAsReader("sql/CC21-01.sql"));
		// runner.closeConnection();
		// conn.close();

	}
}
