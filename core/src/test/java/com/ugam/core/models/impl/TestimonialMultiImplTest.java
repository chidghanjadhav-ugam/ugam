package com.ugam.core.models.impl;

import com.ugam.core.models.FactAreaModel;
import com.ugam.core.models.TestimonialMulti;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class TestimonialMultiImplTest {
    private final AemContext aemContext = new AemContext();
    private TestimonialMulti testimonialMulti;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/testimonialMulti.json", "/content");
    }

    @Test
    void getTestimonialXF() {
        Resource json = aemContext.currentResource("/content");
        testimonialMulti = aemContext.request().adaptTo(TestimonialMulti.class);
        assertEquals("Do you want to be even more successful? Learn to love learning and growth. The more effort you put into improving your skills, the bigger the payoff you.", testimonialMulti.getTestimonialXF().get(0).get("description"));
        assertEquals("Harriet Maxwell", testimonialMulti.getTestimonialXF().get(0).get("name"));
        assertEquals("CEO at Google", testimonialMulti.getTestimonialXF().get(0).get("title"));
    }
}