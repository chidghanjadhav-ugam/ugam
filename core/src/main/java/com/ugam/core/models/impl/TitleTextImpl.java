package com.ugam.core.models.impl;


import com.ugam.core.models.TitleText;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = TitleText.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TitleTextImpl implements TitleText {


    @Inject
    String title;

    @Inject
    String text;

    @Inject
    boolean sectionGap;

    @Inject
    boolean bottomPadding;

    @Inject
    boolean colour;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public boolean getSectionGap() {
        return sectionGap;
    }

    @Override
    public boolean getBottomPadding() {
        return bottomPadding;
    }

    @Override
    public boolean getColour() {
        return colour;
    }
}