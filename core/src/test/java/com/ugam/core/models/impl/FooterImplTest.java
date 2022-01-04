package com.ugam.core.models.impl;

import com.ugam.core.models.Footer;
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
class FooterImplTest {
    private final AemContext aemContext = new AemContext();
    private Footer footer;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/footer.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("About Me", footer.getTitle());
    }

    @Test
    void getDescription() {
        Resource json = aemContext.currentResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("We have tested a number of registry fix and clean utilities and present our top 3 list on our site for your convenience.", footer.getDescription());
    }

    @Test
    void getTitle2() {
        Resource json = aemContext.currentResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("Newsletter", footer.getTitle2());
    }

    @Test
    void getDescription2() {
        Resource json = aemContext.currentResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("Stay updated with our latest trends", footer.getDescription2());
    }

    @Test
    void getTitle3() {Resource json = aemContext.currentResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("Follow Me", footer.getTitle3());
    }

    @Test
    void getDescription3() {
        Resource json = aemContext.currentResource("/content/footer");
        footer = json.adaptTo(Footer.class);
        assertEquals("Let us be social", footer.getDescription3());
    }
}