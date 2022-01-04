package com.ugam.core.models.impl;

import com.ugam.core.models.HomeAbout;
import com.ugam.core.models.Services;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class ServicesImplTest {
    private final AemContext aemContext = new AemContext();
    private Services services;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/services.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/services");
        services = json.adaptTo(Services.class);
        assertEquals("Photography", services.getTitle());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/services");
        services = json.adaptTo(Services.class);
        assertEquals("Do you want to be even more successful? Learn to love learning and growth. The more effort you put into improving your skills.", services.getText());
    }
}