package com.ugam.core.models.impl;


import com.ugam.core.models.Price;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Price.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class PriceImpl implements Price{

    @Inject
    String titleNumber;

    @Inject
    String title;

    @Inject
    String text;

    @Inject
    String priceText1;

    @Inject
    String priceText2;

    @Inject
    String priceText3;

    @Override
    public String getTitleNumber() {
        return titleNumber;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getPriceText1() {
        return priceText1;
    }

    @Override
    public String getPriceText2() {
        return priceText2;
    }

    @Override
    public String getPriceText3() {
        return priceText3;
    }
}
