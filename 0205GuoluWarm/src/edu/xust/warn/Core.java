package edu.xust.warn;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.job.GuoLuAuxJob;
import edu.xust.job.GuoLuMainJob;
import edu.xust.job.GuoLuMainJob2;
import edu.xust.job.GuoLuMainJob3;
import edu.xust.job.GuoLuoSafetyJob;
import edu.xust.warn.log.LogDemoJFrame;

public class Core 
{
	private static Logger log = LoggerFactory.getLogger(Core.class);
	private static Scheduler sched = getScheduler();
	private static  int i=0;
	private static  int j=0;
/*******************主函数*****************************************************************************************/
	public static void main(String[] args) throws Exception {

	 	 final JFrame jf1=new JFrame();
		 Container container=jf1.getContentPane();
		 jf1.setBounds(350,150, 300, 450);
		 jf1.setLayout(null);
		 jf1.setResizable(false);
		 jf1.setTitle("多源信息预警预报系统");
		 JLabel   back=new JLabel();
		 back.setBounds(0, 0, 300, 450);
		 Icon  icon_back=new ImageIcon("images/background.png");
		 back.setIcon(icon_back);
		 //窗口关闭事件
		 jf1.addWindowListener(
				 new WindowAdapter() 
				 {
				   public void windowClosing(WindowEvent e) 
				   {
						 super.windowClosing(e);  
						 int a = JOptionPane.showConfirmDialog(null, "是否要关闭？");
							if (a == JOptionPane.YES_NO_OPTION) 
							{
							System.exit(0);
							}
							else  
							{
								jf1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// 点击取消和否后不会关闭窗口
							}
				   }   
						 }
						 		);
		 //状态标识
		 final JLabel   lable_biaoshi=new JLabel();
		 lable_biaoshi.setBounds(80, 135, 130, 130);
		 final Icon  icon_stop=new ImageIcon("images/stop.png");
		 lable_biaoshi.setIcon(icon_stop);
	
		//启动按钮
		 final Icon  icon_kaishi=new ImageIcon("images/kaishi.png");
		 final  JButton  start=new JButton(icon_kaishi);         
         start.setSize(174,75);
         start.setLocation(60,300);
         //创建日志对象
        final LogDemoJFrame logDemoFrame =  new LogDemoJFrame();  
        logDemoFrame.setLocation(660, 150);
         //显示日志按钮
		 final  JButton  log=new JButton("显示日志");         
		 log.setSize(100,20);
		 log.setLocation(180,90);
		 log.setVisible(false);
		 log.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(j %2==0){
					  logDemoFrame.setVisible(true);  
					  log.setText("关闭日志");
					  j++;
				}else{
					 logDemoFrame.setVisible(false);  
					  log.setText("显示日志");
					 j++;
				}	
			}
		}); 
         //定义两个图片，用于按钮和标识
         final  Icon  icon_start=new ImageIcon("images/start.png");
         final Icon  icon_tingzhi=new ImageIcon("images/tingzhi.png");
  
         //开始按钮的点击事件
        	  start.addActionListener(new ActionListener() {	
       			@Override
       			public void actionPerformed(ActionEvent arg0) {
       				// TODO Auto-generated method stub   			   
       				if(i %2==0){
       				   int a = JOptionPane.showConfirmDialog(null, "是否要启动系统？");
  				    	if (a == JOptionPane.YES_NO_OPTION) {
  						try {      				
  	          				lable_biaoshi.setIcon(icon_start);	
  	          				start.setIcon(icon_tingzhi);
						   logDemoFrame.initLog();  
						   log.setVisible(true);
/*******************************************************程序分析启动*******************************************/
						   Core example = new Core();
						   example.run();	
/*******************************************************程序分析启动*******************************************/
  							i=i+1;
  						} catch (Exception e) {
  							// TODO Auto-generated catch block
  							e.printStackTrace();
  						}	
  						}else {
  	 						jf1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// 点击取消和否后不会关闭窗口
  	 					}	  		
       				}else{      					
       				  int a = JOptionPane.showConfirmDialog(null, "是否要停止系统？");
				    	if (a == JOptionPane.YES_NO_OPTION) {
						try {      	
							lable_biaoshi.setIcon(icon_stop);	
	          				start.setIcon(icon_kaishi);
                           System.exit(0);   						    
							i=i+1;
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						}else {
	 						jf1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// 点击取消和否后不会关闭窗口
	 					}	  		
       				    				
       				}
       			}	
       		});     
        	  
         //将组建添加到容器
         container.add(back);
         back.add(lable_biaoshi);
         back.add(start);
         back.add(log);
		 jf1.setVisible(true);
	}
/*******************主函数*****************************************************************************************/
	/**
	 * 创建一个调度对象
	 * 
	 * @return
	 * @throws SchedulerException
	 */
	private static Scheduler getScheduler() {
		log.info("------- Initializing ----------------------");
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = sf.getScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		log.info("------- Initialization Complete -----------");

		return scheduler;
	}
	public void run() throws Exception {
	log.info("------- Scheduling Job  -------------------");
//    	cron表达式是一个由7个子表达式组成的字符串，各个子表达式通过空白符分隔，分别描述了调度的详细信息。
//	    秒
//	    分
//	    小时
//	    每月的第几天
//	    月
//	    每周的第几天
//	    年(可选的)
//		”0 0 12 ? * WED”，表示每个礼拜三的12点。
//		”0 0 12 ? * WED”，表示每个礼拜三的12点。0 0/5 * * * ?" : 每隔5分钟触发一次
//		"10 0/5 * * * ?" : 从每分钟的第10秒开始，每隔五分钟触发
//		"0 30 10-13 ? * WED,FRI" : 每个周三，周五的10:30,11:30,12:30和13:30触发
		/* 
		-------------------------------------- 
		    0 0 12 * * ?            每天12点触发 
		    0 15 10 ? * *           每天10点15分触发 
		    0 15 10 * * ?           每天10点15分触发 
		    0 15 10 * * ? *         每天10点15分触发 
		    0 15 10 * * ? 2005      2005年每天10点15分触发 
		    0 * 14 * * ?            每天下午的 2点到2点59分每分触发 
		    0 0/5 14 * * ?          每天下午的 2点到2点59分(整点开始，每隔5分触发) 
		    0 0/5 14,18 * * ?       每天下午的 2点到2点59分(整点开始，每隔5分触发) 每天下午的 18点到18点59分(整点开始，每隔5分触发) 
		    0 0-5 14 * * ?          每天下午的 2点到2点05分每分触发 
		    0 10,44 14 ? 3 WED      3月分每周三下午的 2点10分和2点44分触发 
		    0 15 10 ? * MON-FRI     从周一到周五每天上午的10点15分触发 
		    0 15 10 15 * ?          每月15号上午10点15分触发 
		    0 15 10 L * ?           每月最后一天的10点15分触发 
		    0 15 10 ? * 6L          每月最后一周的星期五的10点15分触发 
		    0 15 10 ? * 6L 2002-2005    从2002年到2005年每月最后一周的星期五的10点15分触发 
		    0 15 10 ? * 6#3         每月的第三周的星期五开始触发 
		    0 0 12 1/5 * ?          每月的第一个中午开始每隔5天触发一次 
		    0 11 11 11 11 ?         每年的11月11号 11点11分触发(光棍节) 
		-------------------------------------- 
		参考：http://wwwcomy.iteye.com/blog/1743854
		 */  
		
		log.info("------- Starting Job Complete ----------------");
		log.info("------- Starting Scheduler ----------------");
		sched.start();
		log.info("------- Started Scheduler -----------------");
//		log.info("------- Shutting Down ---------------------");
		// sched.shutdown(true);
//		log.info("------- Shutdown Complete -----------------")
				/* 
				 * 锅炉主体设备1号锅炉调度程序
				 * 
				 * */
				//锅炉任务定义
		JobDetail     job = JobBuilder.newJob(GuoLuMainJob.class)
						.withIdentity("GuoLuMainJob", "group1").build();	
				//锅炉触发器定义，每2秒执行一次
		CronTrigger    trigger = (CronTrigger) TriggerBuilder
						.newTrigger()
						.withIdentity("GuoLuMainJobTrigger", "group1")
						.withSchedule(
								CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
						.build();
			    Date	 ft = sched.scheduleJob(job, trigger);
				log.info(job.getKey() + " has been scheduled to run at: " + ft
						+ " and repeat based on expression: "
						+ trigger.getCronExpression());				
	
			/**
			 * 锅炉主体设备2号锅炉调度程序
			 */
				//锅炉任务定义
		  job = JobBuilder.newJob(GuoLuMainJob2.class)
						.withIdentity("GuoLuMainJob2", "group1").build();	
				//锅炉触发器定义，每2秒执行一次
		  trigger = (CronTrigger) TriggerBuilder
						.newTrigger()
						.withIdentity("GuoLuMainJob2Trigger", "group1")
						.withSchedule(
								CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
						.build();
			    	 ft = sched.scheduleJob(job, trigger);
				log.info(job.getKey() + " has been scheduled to run at: " + ft
						+ " and repeat based on expression: "
						+ trigger.getCronExpression());
				
				
				/**
				 * 锅炉主体设备3号锅炉调度程序
				 */
					//锅炉任务定义
			  job = JobBuilder.newJob(GuoLuMainJob3.class)
							.withIdentity("GuoLuMainJob3", "group1").build();	
					//锅炉触发器定义，每2秒执行一次
			  trigger = (CronTrigger) TriggerBuilder
							.newTrigger()
							.withIdentity("GuoLuMainJob3Trigger", "group1")
							.withSchedule(
									CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
							.build();
				    	 ft = sched.scheduleJob(job, trigger);
					log.info(job.getKey() + " has been scheduled to run at: " + ft
							+ " and repeat based on expression: "
							+ trigger.getCronExpression());		
				
				
				
				/* 
				 * 锅炉辅助设备调度程序
				 * */
				//锅炉任务定义
		  job = JobBuilder.newJob(GuoLuAuxJob.class)
						.withIdentity("GuoLuAuxJob", "group1").build();	
				//锅炉触发器定义，每2秒执行一次
		  trigger = (CronTrigger) TriggerBuilder
						.newTrigger()
						.withIdentity("GuoLuAuxJobTrigger", "group1")
						.withSchedule(
								CronScheduleBuilder.cronSchedule("0/3 * * * * ?"))
						.build();
			    	 ft = sched.scheduleJob(job, trigger);
				log.info(job.getKey() + " has been scheduled to run at: " + ft
						+ " and repeat based on expression: "
						+ trigger.getCronExpression());				
					
				
				/* 
				 * 锅炉月度评价调度程序
				 * */
				//锅炉月度评价任务定义
		         job = JobBuilder.newJob(GuoLuoSafetyJob.class)
						.withIdentity("GuoLuoSafetyJob", "group1").build();	
				//锅炉月度评价触发器定义，每2秒执行一次
		          trigger = (CronTrigger) TriggerBuilder
						.newTrigger()
						.withIdentity("GuoLuoSafetyJobTrigger", "group1")
						.withSchedule(
							    //0 15 10 15 * ?          每月15号上午10点15分触发 
								//0 0 12 1 * ?    每月1号12点0分0秒触发 
							//CronScheduleBuilder.cronSchedule("0 0 12 1 * ?")).build();
						CronScheduleBuilder.cronSchedule("0/3 * * * * ?")).build();
				 ft = sched.scheduleJob(job, trigger);
				log.info(job.getKey() + " has been scheduled to run at: " + ft
						+ " and repeat based on expression: "
						+ trigger.getCronExpression());				
	}
}
