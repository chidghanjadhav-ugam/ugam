package com.ugam.core.models.impl;

import com.ugam.core.models.Price;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class PriceImplTest {
    private final AemContext aemContext = new AemContext();
    private Price price;

    @BeforeEach
    void setUp() {
        Resource json = aemContext.load().json("/price.json","/content");
    }

    @Test
    void getTitleNumber() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("02", price.getTitleNumber());
    }

    @Test
    void getTitle() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Business", price.getTitle());
    }

    @Test
    void getText() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("For the individuals", price.getText());
    }

    @Test
    void getPriceText1() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Secure Online Transfer", price.getPriceText1());
    }

    @Test
    void getPriceText2() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Unlimited Styles for interface", price.getPriceText2());
    }

    @Test
    void getPriceText3() {
        Resource json = aemContext.resourceResolver().getResource("/content/price");
        Price price = json.adaptTo(Price.class);
        assertEquals("Reliable Customer Service", price.getPriceText3());
    }
}