package com.ugam.core.models.impl;

import com.ugam.core.models.BlogTeaser;
import com.ugam.core.models.HomeAbout;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class HomeAboutImplTest {
    private final AemContext aemContext = new AemContext();
    private HomeAbout homeAbout;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/homeAbout.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("About Me", homeAbout.getTitle());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("Personal Details", homeAbout.getText());
    }

    @Test
    void getDescription() {
        Resource json = aemContext.currentResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("Here, I focus on a range of items and features that we use in life without giving them a second thought. such as Coca Cola. Dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.", homeAbout.getDescription());
    }

    @Test
    void getButton() {
        Resource json = aemContext.currentResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("View Full Details", homeAbout.getButton());
    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("/content/dam/ugam/about-img.png", homeAbout.getImage());
    }

    @Test
    void getPath() {
        Resource json = aemContext.currentResource("/content/homeabout");
        homeAbout = json.adaptTo(HomeAbout.class);
        assertEquals("/content/ugam/us/en/about", homeAbout.getPath());
    }

}