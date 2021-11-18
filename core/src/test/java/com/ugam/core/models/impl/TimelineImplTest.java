package com.ugam.core.models.impl;

import com.ugam.core.models.Timeline;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TimelineImplTest {
    private final AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    private Timeline timeline;

    @BeforeEach
    void setUp() {
        Resource json = aemContext.load().json("/timeline.json","/content");
    }

    @Test
    void getTimeline() {
        Resource json = aemContext.currentResource("/content/timeline");
        Timeline timeline = json.adaptTo(Timeline.class);
        assertNotNull(timeline.getTimeline());
    }
}