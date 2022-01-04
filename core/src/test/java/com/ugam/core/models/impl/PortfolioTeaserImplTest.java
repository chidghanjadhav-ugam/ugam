package com.ugam.core.models.impl;

import com.ugam.core.models.HomeAbout;
import com.ugam.core.models.PortfolioTeaser;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PortfolioTeaserImplTest {
    private final AemContext aemContext = new AemContext();
    private PortfolioTeaser portfolioTeaser;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/portfolioTeaser.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/portfolioteaser");
        portfolioTeaser = json.adaptTo(PortfolioTeaser.class);
        assertEquals("2D Vinyl Design", portfolioTeaser.getTitle());
    }

    @Test
    void getText() {
        Resource json = aemContext.currentResource("/content/portfolioteaser");
        portfolioTeaser = json.adaptTo(PortfolioTeaser.class);
        assertEquals("raster", portfolioTeaser.getText());
    }
}