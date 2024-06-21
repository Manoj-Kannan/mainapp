package com.omega.mainapp.jobservice;

import com.omega.jobservice.jobconfig.JobConfig;
import com.omega.jobservice.jobconfig.JobContext;
import com.omega.mainapp.utils.EmailUtils;

public abstract class AbstractJobConfig implements JobConfig {
    @Override
    public abstract String getJobFilePath();

    @Override
    public abstract String getExecFilePath();

    @Override
    public abstract boolean isEnabledService();

    @Override
    public void emailException(String fromClass, String msg, Throwable t) {
        EmailUtils.emailException(fromClass, msg, t);
    }

    @Override
    public void emailException(String fromClass, String msg, String reason) {
        EmailUtils.emailException(fromClass, msg, reason);
    }

    @Override
    public void log(JobContext jobContext, long timeTaken, JobContext.JobStatus status) {

    }
}
