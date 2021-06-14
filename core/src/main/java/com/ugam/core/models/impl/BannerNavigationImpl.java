package com.ugam.core.models.impl;


import com.ugam.core.models.BannerNavigation;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = BannerNavigation.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class BannerNavigationImpl implements BannerNavigation{

    @Inject
    String title;

    @Inject
    String text;

    @Inject
    String navText;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getNavText() {
        return navText;
    }
}
