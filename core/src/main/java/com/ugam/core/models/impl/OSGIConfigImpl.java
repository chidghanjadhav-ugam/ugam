package com.ugam.core.models.impl;

import com.ugam.core.models.OSGIConfig;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.*;
@Component(service = OSGIConfig.class, immediate = true)
@Designate(ocd = OSGIConfigImpl.ServiceConfig.class)

public class OSGIConfigImpl implements OSGIConfig {

    @ObjectClassDefinition(name = "Ugam - OSGI CONFIGURATION",
            description = "Ugam osgi config.")

    public @interface ServiceConfig{
        @AttributeDefinition(
                name="Name",
                description = "Enter Name",
                type = AttributeType.STRING)
        public String serviceName() default "Enter Name";
        @AttributeDefinition(
                name="Count",
                description = "Count",
                type = AttributeType.INTEGER)
        int getCount() default 1;
        @AttributeDefinition(
                name = "Check Mark",
                description = "Check the box.",
                type = AttributeType.BOOLEAN)
        boolean getDataLive() default false;
        @AttributeDefinition(
                name = "Instance",
                description = "Select Instance",
                options = {
                        @Option(label = "Author",value = "author"),
                        @Option(label = "Publish",value = "publish"),
                        @Option(label = "Both",value = "both")
                },
                type = AttributeType.STRING)
        String getRunMode() default "both";

    }
    private String serviceName;
    private int count;
    private boolean datalive;
    private String runModes;
    @Activate
    protected void activate(ServiceConfig serviceConfig){
        serviceName=serviceConfig.serviceName();
        count=serviceConfig.getCount();
        datalive=serviceConfig.getDataLive();
        runModes=serviceConfig.getRunMode();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public boolean isDataLive() {
        return datalive;
    }

    @Override
    public String getRunModes() {
        return runModes;
    }
}
