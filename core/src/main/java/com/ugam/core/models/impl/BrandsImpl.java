package com.ugam.core.models.impl;


import com.ugam.core.models.Brands;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(adaptables = Resource.class,
        adapters = Brands.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class BrandsImpl implements Brands{

    @Inject
    List<String> imagePath;
    @Override
    public List<String> getImagePath() {
        if(imagePath!=null){
            return new ArrayList<>(imagePath);
        }
        else {
            return Collections.emptyList();
        }
    }
}
