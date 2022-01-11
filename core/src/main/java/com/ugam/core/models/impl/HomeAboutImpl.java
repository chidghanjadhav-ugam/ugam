package com.ugam.core.models.impl;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugam.core.models.HomeAbout;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = HomeAbout.class,
        resourceType = HomeAboutImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name="jackson", extensions = "json", selector = "homeabout",
options = {
            @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value = "true")
})
@JsonRootName("Home About Exporter")
public class HomeAboutImpl implements HomeAbout{
    static final String RESOURCE_TYPE = "ugam/components/content/homeabout";

    @Inject
    String title;

    @Inject
    String text;

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
    public String getText() {
        return text;
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
