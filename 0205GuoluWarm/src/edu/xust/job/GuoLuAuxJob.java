package edu.xust.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.xust.expert.Expert;
import edu.xust.expert.guolu.GuoLuAuxExpert;

//锅炉专家任务例子
public class GuoLuAuxJob implements Job {
	private static Logger log = LoggerFactory.getLogger(GuoLuAuxJob.class);

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		//此处添加锅炉专家分析代码
		Expert expert=new GuoLuAuxExpert();
		log.info("锅炉辅助设备专家 - 开始分析+++" );
		expert.start();
		log.info("锅炉辅助设备专家 - 结束分析" );
	}
}
