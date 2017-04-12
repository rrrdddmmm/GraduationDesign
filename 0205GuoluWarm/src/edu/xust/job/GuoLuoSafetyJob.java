package edu.xust.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.expert.Expert;
import edu.xust.expert.guolu.GuoLuoSafetyExpert;

public class GuoLuoSafetyJob  implements Job  {
	private static Logger log = LoggerFactory.getLogger(GuoLuMainJob.class);

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		//此处添加风机专家分析代码
		Expert expert=new GuoLuoSafetyExpert();
		log.info("锅炉评价专家 - 开始分析" );
		expert.start();
		log.info("锅炉评价专家- 结束分析" );
	}

}
