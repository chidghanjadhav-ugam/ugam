package com.ugam.core.models.impl;


import com.ugam.core.models.TestimonialMulti;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = TestimonialMulti.class,
        resourceType = TimelineImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TestimonialMultiImpl implements TestimonialMulti{
    static final String RESOURCE_TYPE = "ugam/components/content/testimonialmulti";

    @ChildResource
    Resource testimonialmultifield;

    @Override
    public List<Map<String, String>> getTestimonialXF() {
        List<Map<String, String>> testimonialAreaMap = new ArrayList<>();
        if (testimonialmultifield != null) {
            for(Resource testimonial : testimonialmultifield.getChildren()){
                Map<String,String> testimonailMap = new HashMap<>();
                testimonailMap.put("description",testimonial.getValueMap().get("description",String.class));
                testimonailMap.put("name",testimonial.getValueMap().get("name",String.class));
                testimonailMap.put("title",testimonial.getValueMap().get("title",String.class));
                testimonialAreaMap.add(testimonailMap);
            }
        }
        return testimonialAreaMap;
    }
}
