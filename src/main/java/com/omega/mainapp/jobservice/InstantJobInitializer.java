package com.omega.mainapp.jobservice;

import com.omega.jobservice.instantjob.InstantJobController;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.omega.mainapp.utils.FileUtils;
import org.apache.commons.chain.Context;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Component
public class InstantJobInitializer {
    private static final Logger LOGGER = LogManager.getLogger(InstantJobInitializer.class.getName());
    private static final String INSTANT_JOBS_FILE = FileUtils.normalizePath("conf/instantJobs.xml");
    private static final String INSTANT_JOB_EXECUTOR_FILE = FileUtils.normalizePath("conf/instantJobExecutors.xml");

    static class InstantJobConfigImpl extends AbstractJobConfig {

        @Override
        public String getJobFilePath() {
            return INSTANT_JOBS_FILE;
        }

        @Override
        public String getExecFilePath() {
            return INSTANT_JOB_EXECUTOR_FILE;
        }

        @Override
        public boolean isEnabledService() {
            return true;
        }
    }


    @EventListener
    public static void init(ContextRefreshedEvent event) throws Exception {
        LOGGER.info("Application context refreshed - InstantJobInitializer");
        InstantJobController.initScheduler(new InstantJobConfigImpl());
    }

    @EventListener
    public static void stopExecutors(ContextClosedEvent event) {
        LOGGER.info("Application context closed - InstantJobInitializer");
        InstantJobController.stopExecutors();
    }

    public static void deleteExecutorsInstantJobQueueTable() throws Exception {
        InstantJobController.deleteExecutorsInstantJobQueueTable();
    }

    public static void addInstantJob(String executorName, String jobName, Context context) throws Exception {
        InstantJobController.addInstantJob(executorName, jobName, context);
    }
}
