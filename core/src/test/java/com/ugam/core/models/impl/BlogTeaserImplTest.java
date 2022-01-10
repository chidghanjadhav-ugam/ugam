package com.ugam.core.models.impl;

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
class BlogTeaserImplTest {
    private final AemContext aemContext = new AemContext();
    private BlogTeaser blogTeaser;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/blogTeaser.json", "/content");
    }

    @Test
    void getTitle() {
        Resource json = aemContext.currentResource("/content/blogteaser");
        blogTeaser = json.adaptTo(BlogTeaser.class);
        assertEquals("Do Dreams Serve As A Premonition", blogTeaser.getTitle());
    }

    @Test
    void getDescription() {
        Resource json = aemContext.currentResource("/content/blogteaser");
        blogTeaser = json.adaptTo(BlogTeaser.class);
        assertEquals("So many of us are demotivated to achieve anything. Such people are not enthusiastic about anything. They don’t want to work involved.", blogTeaser.getDescription());
    }

    @Test
    void getImage() {
        Resource json = aemContext.currentResource("/content/blogteaser");
        blogTeaser = json.adaptTo(BlogTeaser.class);
        assertEquals("/content/dam/ugam/b3.jpg", blogTeaser.getImage());
    }
}