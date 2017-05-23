package com.xkd.util;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Test {

	/**
	 * @param args
	 * @throws XMLParserException
	 * @throws IOException
	 * @throws InvalidConfigurationException
	 * @throws InterruptedException
	 * @throws SQLException
	 */
	public static void main(String[] args) {
		FileDealWith.deleteAllFilesOfDir(new File("F:/resource/1/20170519140228"));

	}
}
