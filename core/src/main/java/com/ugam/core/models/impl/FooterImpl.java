package com.ugam.core.models.impl;


import com.ugam.core.models.Footer;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Footer.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FooterImpl implements Footer{

    @Inject
    String title;

    @Inject
    String description;

    @Inject
    String title2;

    @Inject
    String description2;

    @Inject
    String title3;

    @Inject
    String description3;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTitle2() {
        return title2;
    }

    @Override
    public String getDescription2() {
        return description2;
    }

    @Override
    public String getTitle3() {
        return title3;
    }

    @Override
    public String getDescription3() {
        return description3;
    }
}
