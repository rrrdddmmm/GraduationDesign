package com.xkd.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

public class CommController {
	
	public WebApplicationContext getWebApplicationContext(HttpServletRequest request){
		
		return 	WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
	
	}
	
	public void toJSON(HttpServletResponse response, Object obj)throws Exception{
		response.setCharacterEncoding("utf-8");
		PrintWriter   out =response.getWriter();
		out.print(new Gson().toJson(obj));
		out.flush();
		out.close();
		
	}
	
	public void toStr(HttpServletResponse response, String str)throws Exception{
		response.setCharacterEncoding("utf-8");
		PrintWriter   out =response.getWriter();
		out.print(str);
		out.flush();
		out.close();
	}

}
