package com.omega.mainapp.jobservice;

import com.omega.jobservice.scheduledjob.ScheduledJobController;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.omega.mainapp.utils.FileUtils;

@Component
public class ScheduledJobInitializer {
    private static final String SCHEDULED_JOBS_FILE = FileUtils.normalizePath("conf/scheduledJobs.xml");
    private static final String SCHEDULED_JOB_EXECUTOR_FILE = FileUtils.normalizePath("conf/scheduledJobExecutors.xml");

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
    public static void init(ContextRefreshedEvent event) throws Exception {
        System.out.println("Application context refreshed - ScheduledJobInitializer");
        ScheduledJobController.initScheduler(new ScheduledJobConfigImpl());
    }

    @EventListener
    public static void stopExecutors(ContextClosedEvent event) {
        System.out.println("Application context closed - ScheduledJobInitializer");
        ScheduledJobController.stopSchedulers();
    }
}
