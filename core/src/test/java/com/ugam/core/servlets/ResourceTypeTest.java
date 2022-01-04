package com.ugam.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class ResourceTypeTest {
    AemContext aemContext = new AemContext();
    ResourceType resourceType = new ResourceType();

    @BeforeEach
    void setUp() {
    }

    @Test
    void doGet() throws IOException {
        MockSlingHttpServletRequest request = aemContext.request();
        MockSlingHttpServletResponse response = aemContext.response();
        aemContext.create().page("/content/ugam/us/en");
        aemContext.create().page("/content/ugam/us/en/portfoilo");
        resourceType.doGet(request, response);
        List pageList = new ArrayList();
        pageList.add("portfoilo");
        assertEquals(pageList.toString(), response.getOutputAsString());
    }
}