package com.ugam.core.models.impl;

import com.ugam.core.models.BannerNavigation;
import com.ugam.core.models.BlogTeaser;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BannerNavigationImplTest {
    private final AemContext aemContext = new AemContext();
    private BannerNavigation bannerNavigation;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/bannernav.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/bannernav");
        bannerNavigation = json.adaptTo(BannerNavigation.class);
        assertEquals("About Me", bannerNavigation.getTitle());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/bannernav");
        bannerNavigation = json.adaptTo(BannerNavigation.class);
        assertEquals("Home", bannerNavigation.getText());
    }

    @Test
    void getNavText() {
        Resource json = aemContext.currentResource("/content/bannernav");
        bannerNavigation = json.adaptTo(BannerNavigation.class);
        assertEquals("About", bannerNavigation.getNavText());
    }

    @Test
    void getPath() {
        Resource json = aemContext.currentResource("/content/bannernav");
        bannerNavigation = json.adaptTo(BannerNavigation.class);
        assertEquals("/content/ugam/us/en/home", bannerNavigation.getPath());
    }
}