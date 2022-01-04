package com.ugam.core.models.impl;

import com.ugam.core.models.BlogTeaser;
import com.ugam.core.models.Brands;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BrandsImplTest {
    private final AemContext aemContext = new AemContext();
    private Brands brands;

    @BeforeEach
    void setUp() {
        aemContext.load().json("/brands.json", "/content");
    }

    @Test
    void getImagePath() {
        Resource json = aemContext.currentResource("/content/brands");
        brands = json.adaptTo(Brands.class);
        assertEquals(5, brands.getImagePath().size());
        assertEquals("/content/dam/ugam/l1.png", brands.getImagePath().get(0));
        assertEquals("/content/dam/ugam/l2.png", brands.getImagePath().get(1));
        assertEquals("/content/dam/ugam/l3.png", brands.getImagePath().get(2));
        assertEquals("/content/dam/ugam/l4.png", brands.getImagePath().get(3));
        assertEquals("/content/dam/ugam/l5.png", brands.getImagePath().get(4));
    }
    @Test
    void getNoBrands(){
        Resource json = aemContext.currentResource("/content/nobrands");
        brands = json.adaptTo(Brands.class);
        assertEquals(0, brands.getImagePath().size());
    }
}