package com.ugam.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class FactAreaModelTest {
    private final AemContext aemContext = new AemContext();
    private FactAreaModel factAreaModel;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/factArea.json", "/content");
    }

    @Test
    void getFactArea() {
        Resource resource = aemContext.currentResource("/content");
        factAreaModel = aemContext.request().adaptTo(FactAreaModel.class);
        assertEquals("Projects Completed", factAreaModel.getFactArea().get(0).get("factText"));
        assertEquals("2536", factAreaModel.getFactArea().get(0).get("factNumber"));

    }
}