package com.ugam.core.models.impl;


import com.ugam.core.models.BannerArea;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = BannerArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class BannerAreaImpl implements BannerArea{

    @Inject
    String title;

    @Inject
    String name;

    @Inject
    String description;

    @Inject
    String button;

    @Inject
    String image;

    @Inject
    String path;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getButton() {
        return button;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getPath() {
        return path;
    }
}
