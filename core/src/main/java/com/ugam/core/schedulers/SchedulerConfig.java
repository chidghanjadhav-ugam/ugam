package com.ugam.core.schedulers;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
        name = "Ugam Scheduler Configuration"
)
public @interface SchedulerConfig {

    @AttributeDefinition(
            name = "Schedular",
            description = "Name of the Scheduler",
            type = AttributeType.STRING)
    public String schedulerName() default "Custom Scheduler";

    @AttributeDefinition(
            name = "Cron Expression",
            description = "Cron used by the Scheduler",
            type = AttributeType.STRING)
    public String cronExpression() default "0 0 12 1/1 * ? *";
}
