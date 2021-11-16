package com.ugam.core.models.impl;

import com.ugam.core.models.BannerArea;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BannerAreaImplTest {
    private final AemContext aemContext = new AemContext();
    private BannerArea banner;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/Banner.json","/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea banner = json.adaptTo(BannerArea.class);
        assertEquals("THIS IS ME", banner.getTitle());
    }

    @Test
    void getName() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea banner = json.adaptTo(BannerArea.class);
        assertEquals("PHILIP GILBERT", banner.getName());
    }

    @Test
    void getDescription() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea banner = json.adaptTo(BannerArea.class);
        assertEquals("You will begin to realise why this exercise is called the Dickens Pattern with reference to the ghost showing Scrooge some different futures.", banner.getDescription());
    }

    @Test
    void getButton() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea banner = json.adaptTo(BannerArea.class);
        assertEquals("discover now", banner.getButton());
    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea banner = json.adaptTo(BannerArea.class);
        assertEquals("/content/dam/ugam/hero-img.png", banner.getImage());
    }

    @Test
    void getPath() {
        Resource json = aemContext.currentResource("/content/banner");
        BannerArea banner = json.adaptTo(BannerArea.class);
        assertEquals("/content/ugam/us/en/home", banner.getPath());
    }
}