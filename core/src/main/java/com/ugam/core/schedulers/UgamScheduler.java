package com.ugam.core.schedulers;


import com.ugam.core.models.DateProperty;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true,service = Runnable.class)
@Designate(ocd = SchedulerConfig.class)
public class UgamScheduler implements Runnable{
    public static final Logger LOG = LoggerFactory.getLogger(UgamScheduler.class);

    private int schedulerId;

    String path = "/content/ugam/us/en/userlist/jcr:content/root/container/datetime";

    @Reference
    private DateProperty dataProperty;
    @Reference
    private Scheduler scheduler;
    @OSGiService
    ResourceResolverFactory resourceResolverFactory;

    @Activate
    public void activate(SchedulerConfig config){
        schedulerId=config.schedulerName().hashCode();
        addScheduler(config);
    }

    @Deactivate
    public void deactivate(SchedulerConfig config){
        removeScheuler();
    }

    private void removeScheuler() {
        scheduler.unschedule(String.valueOf(schedulerId));
    }

    private void addScheduler(SchedulerConfig config) {
        ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(false);
        scheduler.schedule(this, scheduleOptions);
        LOG.info("\nScheduler Added");
    }

    @Override
    public void run() {
        dataProperty.addDate(path);
        LOG.info("\nScheduler Running");
    }
}
