package com.omega.mainapp.jobservice;

import com.omega.jobservice.scheduledjob.ScheduledJobController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.omega.mainapp.utils.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Component
public class ScheduledJobInitializer {
    // TODO - Compare EventListener with PostConstruct & PreDestroy
    private static final Logger LOGGER = LogManager.getLogger(ScheduledJobInitializer.class.getName());
    private static final String SCHEDULED_JOBS_FILE = FileUtils.normalizePath("conf/scheduledJobs.xml");
    private static final String SCHEDULED_JOB_EXECUTOR_FILE = FileUtils.normalizePath("conf/scheduledJobExecutors.xml");

    @Autowired
    ScheduledJobController scheduledJobController;

    static class ScheduledJobConfigImpl extends AbstractJobConfig {

        @Override
        public String getJobFilePath() {
            return SCHEDULED_JOBS_FILE;
        }

        @Override
        public String getExecFilePath() {
            return SCHEDULED_JOB_EXECUTOR_FILE;
        }

        @Override
        public boolean isEnabledService() {
            return true;
        }
    }

    @EventListener
    public void init(ContextRefreshedEvent event) throws Exception {
        LOGGER.info("Application context refreshed - ScheduledJobInitializer");
        scheduledJobController.initScheduler(new ScheduledJobConfigImpl());
    }

    @EventListener
    public static void stopExecutors(ContextClosedEvent event) {
        LOGGER.info("Application context closed - ScheduledJobInitializer");
        ScheduledJobController.stopSchedulers();
    }
}
