package com.ugam.core.models.impl;


import com.ugam.core.models.FactArea;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = FactArea.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FactAreaImpl implements FactArea{

    @Inject
    Resource componentResourse;

    @Override
    public List<Map<String, String>> getFactArea() {
        List<Map<String, String>> factAreaMap = new ArrayList<>();
        Resource factDetail = componentResourse.getChild("factareamultifield");
        if(factDetail!=null){
            for(Resource fact : factDetail.getChildren()){
                Map<String,String> factMap = new HashMap<>();
                factMap.put("factNumber",fact.getValueMap().get("factNumber",String.class));
                factMap.put("factText",fact.getValueMap().get("factText",String.class));
                factAreaMap.add(factMap);
            }
        }
        return factAreaMap;
    }
}
