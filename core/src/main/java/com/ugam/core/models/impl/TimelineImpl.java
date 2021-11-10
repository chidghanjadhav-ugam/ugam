package com.ugam.core.models.impl;

import com.ugam.core.models.Timeline;
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
        adapters = Timeline.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TimelineImpl implements Timeline{

    @ChildResource
    Resource timelinemultifield;

    @Override
    public List<Map<String, String>> getTimeline() {
        List<Map<String,String>> timelineAreaMap = new ArrayList<>();
        if(timelinemultifield!=null){
            for(Resource timeline : timelinemultifield.getChildren()){
                Map<String,String> timelinearea=new HashMap<>();
                timelinearea.put("title",timeline.getValueMap().get("title",String.class));
                timelinearea.put("timePeriod",timeline.getValueMap().get("timePeriod",String.class));
                timelinearea.put("text",timeline.getValueMap().get("text",String.class));
                timelineAreaMap.add(timelinearea);
            }
        }
        return timelineAreaMap;
    }
}
