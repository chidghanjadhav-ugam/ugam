package com.ugam.core.models.impl;

import com.ugam.core.models.OSGIConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = OSGIConfig.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OSGIConfigModelImpl implements OSGIConfig {

    @OSGiService
    OSGIConfig osgiConfig;

    @Override
    public String getServiceName() {
        return osgiConfig.getServiceName();
    }

    @Override
    public int getCount() {
        return osgiConfig.getCount();
    }

    @Override
    public boolean isDataLive() {
        return osgiConfig.isDataLive();
    }

    @Override
    public String getRunModes() {
        return osgiConfig.getRunModes();
    }

}