package edu.xust.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.expert.Expert;
import edu.xust.expert.guolu.GuoLuMainExpert2;

public class GuoLuMainJob2 implements Job {//实例化时间调度（job）接口
	private static Logger log = LoggerFactory.getLogger(GuoLuMainJob2.class);

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		//此处添加风机专家分析代码
		log.info("2锅炉专家 - ");
		Expert expert=new GuoLuMainExpert2();//上转型
		log.info("2锅炉主体设备专家 - 开始分析" );
		expert.start();
		log.info("2锅炉主体设备专家- 结束分析" );
	}
}
