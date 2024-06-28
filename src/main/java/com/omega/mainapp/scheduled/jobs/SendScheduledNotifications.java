package com.omega.mainapp.scheduled.jobs;

import com.omega.jobservice.jobconfig.JobContext;
import com.omega.jobservice.scheduledjob.ScheduledJob;
import com.omega.mainapp.sample.service.StudentService;
import com.omega.mainapp.sample.model.Student;
import com.omega.mainapp.utils.TimeUtils;

public class SendScheduledNotifications extends ScheduledJob {
    @Override
    public void execute(JobContext jobContext) throws Exception {
        StudentService studentService = getApplicationContext().getBean(StudentService.class);
        Student student = new Student(jobContext.getJobId(), "Student", TimeUtils.getCurrentTime());
        studentService.addStudent(student);
    }
}
