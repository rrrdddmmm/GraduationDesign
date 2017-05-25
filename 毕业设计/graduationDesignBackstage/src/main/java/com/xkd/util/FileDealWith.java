package com.xkd.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.xkd.entity.StateResult;

public class FileDealWith {
	/**
	 * 该方法实现配置一个property文件属性
	 * 
	 * @param key
	 *            需设置的键
	 * @param value
	 *            键对应的值
	 */
	public static void setProperties(String key, String value) {
		FileOutputStream outStream = null;
		File file = null;
		try {
			// 读取文件
			file = new File("config/properties.properties");
			// 判断文件是否存在，不存在则创建一个properties属性文件
			if (!file.exists()) {
				file.createNewFile();
			}
			// 声明并实例化一个properties对象
			Properties properties = new Properties();
			// 使用setter方法设置键值对 key value
			properties.setProperty(key, value);
			// 实例化输出流对象
			outStream = new FileOutputStream(file);
			// 使用store方法将properties送到输入流
			properties.store(outStream, null);
		} catch (FileNotFoundException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
			// 确保出异常之前把流关闭
		} finally {
			try {
				// 关闭流文件
				// 判断流是否打开
				if (outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}
		}
	}

	/**
	 * 通过键来查询对应的值
	 * 
	 * @param key
	 *            键
	 * @return value的值是key对应的值
	 */
	public static String getProperties(String key) {
		FileInputStream inStream = null;
		File file = null;
		String value = null;
		try {
			// 读取文件
			file = new File("config/properties.properties");
			// 判断文件是否存在，不存在则返回
			if (!file.exists()) {
				return value = "2013/01/02 14:36:00";
			}
			// 将文件读取到输入流
			inStream = new FileInputStream(file);
			// 声明并实例化一个properties对象
			Properties properties = new Properties();
			// 使用properties类中load方法将io流内容导入
			properties.load(inStream);
			// 根据键使用geter方法得到值，并将值赋值给value
			value = properties.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
			// 确保程序出异常能保证流的关闭
		} finally {
			try {
				// 关闭输入流
				// 判断流是否打开
				if (inStream != null) {
					inStream.close();
				}
			} catch (IOException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}
		}
		// 返回value值
		return value;
	}

	/**
	 * 文件下载
	 * 
	 * @return
	 * @throws IOException
	 */
	public static void downloadFile(HttpServletResponse response, String materialAddress) throws IOException {
		File file = new File(materialAddress);
		response.setContentType("multipart/form-data;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ new String(file.getName().getBytes("UTF-8"), "ISO8859-1"));
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[1024];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件路径!");
		} finally {
			inputStream.close();
		}
	}

	/**
	 * 文件夹压缩下载
	 * 
	 * @return
	 * @throws IOException
	 */
	public static void iteratorDirdownjoad(HttpServletResponse response, String filepath) throws IOException {
		String[] fileName = filepath.split("/");
		File zipFile = new File(filepath + "/" + fileName[fileName.length - 1] + ".zip");
		if (zipFile.exists()) {
			zipFile.delete();
		}
		boolean flag = fileToZip(filepath, filepath, fileName[fileName.length - 1]);
		if (flag) {
			downloadFile(response, filepath + "/" + fileName[fileName.length - 1] + ".zip");
			System.out.println("文件打包成功!");
		} else {
			System.out.println("文件打包失败!");
		}
	}

	/**
	 * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
	 * 
	 * @param sourceFilePath
	 *            :待压缩的文件路径
	 * @param zipFilePath
	 *            :压缩后存放路径
	 * @param fileName
	 *            :压缩后文件的名称
	 * @return
	 */
	@SuppressWarnings("resource")
	public static boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
		boolean flag = false;
		File sourceFile = new File(sourceFilePath);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		if (sourceFile.exists() == false) {
			System.out.println("待压缩的文件目录：" + sourceFilePath + "不存在.");
		} else {
			try {
				File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
				if (zipFile.exists()) {
					System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
				} else {
					File[] sourceFiles = sourceFile.listFiles();
					if (null == sourceFiles || sourceFiles.length < 1) {
						System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
					} else {
						fos = new FileOutputStream(zipFile);
						zos = new ZipOutputStream(new BufferedOutputStream(fos));
						byte[] bufs = new byte[1024 * 10];
						for (int i = 0; i < sourceFiles.length; i++) {
							// 创建ZIP实体，并添加进压缩包
							ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
							zos.putNextEntry(zipEntry);
							// 读取待压缩的文件并写进压缩包里
							fis = new FileInputStream(sourceFiles[i]);
							bis = new BufferedInputStream(fis, 1024 * 10);
							int read = 0;
							while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
								zos.write(bufs, 0, read);
							}
						}
						flag = true;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				// 关闭流
				try {
					if (null != bis)
						bis.close();
					if (null != zos)
						zos.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return flag;
	}

	public static boolean upload(StateResult stateResult, MultipartFile file, String absPath)
			throws IllegalStateException, IOException {
		if (file != null) {
			if (file.getName() != null || "".equals(file.getName())) {
				System.out.println(file.getOriginalFilename());
				String[] name = file.getOriginalFilename().split("\\.");
				if (stateResult.isMp4()) {
					if ("mp4".equalsIgnoreCase(name[name.length - 1])) {
						File f = new File(absPath);
						if (!f.exists()) {
							f.mkdirs();
						}
						file.transferTo(f);
						return true;
					} else {
						stateResult.setStatus(1);
						stateResult.setMsg("服务器端：请上传mp4视频格式!");
					}
				} else {
					if ("txt".equals(name[name.length - 1]) || "doc".equals(name[name.length - 1])
							|| "docx".equals(name[name.length - 1]) || "pdf".equals(name[name.length - 1])) {
						File f = new File(absPath);
						if (!f.exists()) {
							f.mkdirs();
						}
						file.transferTo(f);
						return true;
					} else {
						stateResult.setStatus(1);
						stateResult.setMsg("服务器端：请上传规定格式!");
					}
				}
			} else {
				stateResult.setStatus(2);
				stateResult.setMsg("服务器端：文件名不能为空!");
			}
		} else {
			stateResult.setStatus(3);
			stateResult.setMsg("服务器端：请选择文件!");
		}
		return false;
	}

	public static void deleteAllFilesOfDir(File path) {
		if (!path.exists())
			return;
		if (path.isFile()) {
			path.delete();
			return;
		}
		File[] files = path.listFiles();
		for (int i = 0; i < files.length; i++) {
			deleteAllFilesOfDir(files[i]);
		}
		path.delete();
	}

}
