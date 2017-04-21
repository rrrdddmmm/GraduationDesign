package com.xkd.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkd.util.FileDealWith;

/**
 * 文件下载
 * @author RBB
 *
 */
@Controller
@RequestMapping("/downLoadController")
public class DownLoadController  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param response
	 */
	 @SuppressWarnings("deprecation")
	@RequestMapping("/downLoad.do")
	public void downLoad(HttpServletResponse response,HttpServletRequest request){
		try {
			File directory = new File("");//设定为当前文件夹 
			System.out.println(directory.getAbsolutePath());
			//
			
			FileDealWith.downloadFile(response, request.getRealPath("/") + "taskfile"+File.separator + "task.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
