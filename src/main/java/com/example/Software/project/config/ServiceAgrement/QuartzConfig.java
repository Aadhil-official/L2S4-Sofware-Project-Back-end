//package com.example.backendArctic.Config;
//
//import com.example.backendArctic.Entity.ReminderJob;
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.SimpleScheduleBuilder;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfig {
//
//    @Bean
//    public JobDetail jobDetail() {
//        return JobBuilder.newJob(ReminderJob.class)
//                .withIdentity("reminderJob")
//                .storeDurably()
//                .build();
//    }
//
//    @Bean
//    public Trigger trigger(JobDetail jobDetail) {
//        return TriggerBuilder.newTrigger()
//                .forJob(jobDetail)
//                .withIdentity("reminderTrigger")
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                        .withIntervalInHours(1)
//                        .repeatForever())
//                .build();
//    }
//}
