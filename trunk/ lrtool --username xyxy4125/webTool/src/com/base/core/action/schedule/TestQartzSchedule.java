package com.base.core.action.schedule;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestQartzSchedule extends QuartzJobBean {

    private static final Log logger = LogFactory.getLog(TestQartzSchedule.class);

    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
        	SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
        	System.out.println("定时启动了，现在时间："+dateFm.format(new Date()));
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
        }
    }

}
