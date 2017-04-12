package edu.xust.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.expert.Expert;
import edu.xust.expert.guolu.GuoLuMainExpert3;

public class GuoLuMainJob3 implements Job {//实例化时间调度（job）接口
	private static Logger log = LoggerFactory.getLogger(GuoLuMainJob3.class);

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		//此处添加风机专家分析代码
		log.info("3锅炉专家 - ");
		Expert expert=new GuoLuMainExpert3();//上转型
		log.info("3锅炉主体设备专家 - 开始分析" );
		expert.start();
		log.info("3锅炉主体设备专家- 结束分析" );
	}
}
