package com.ugam.core.models.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.ugam.core.models.Testimonial;
import com.ugam.core.models.Timeline;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = Resource.class,
        adapters = Timeline.class,
        resourceType = TimelineImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name="jackson", extensions = "json",
        options = {
                @ExporterOption(name = "SerializationFeature.WRAP_ROOT_VALUE", value = "true")
        })
@JsonRootName("Timeline Exporter")
public class TimelineImpl implements Timeline{
    static final String RESOURCE_TYPE = "ugam/components/content/timeline";

    @JsonProperty(value = "Timeline Info")
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
//    @JsonProperty(value = "custom property")
//    public String timeline(){
//        return "Timeline";
//    }
}
