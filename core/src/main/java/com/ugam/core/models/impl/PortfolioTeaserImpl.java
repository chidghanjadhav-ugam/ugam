package com.ugam.core.models.impl;


import com.ugam.core.models.PortfolioTeaser;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = PortfolioTeaser.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class PortfolioTeaserImpl implements PortfolioTeaser{

    @Inject
    String title;

    @Inject
    String text;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }
}
