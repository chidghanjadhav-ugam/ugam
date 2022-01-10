package com.ugam.core.models.impl;

import com.day.cq.wcm.api.Page;
import com.ugam.core.config.UgamCAConfig;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class CAConfigImplTest {
    AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    CAConfigImpl caConfig;
    Page currentPage;
    ResourceResolver resourceResolver = mock(ResourceResolver.class);
    Resource contentResource = mock(Resource.class);
    ConfigurationBuilder configurationBuilder = mock(ConfigurationBuilder.class);
    private String siteCountry;
    private String siteAdmin;
    private String siteSection;

    @BeforeEach
    void setUp() throws NoSuchFieldException {
        caConfig = aemContext.registerService(new CAConfigImpl());
        UgamCAConfig ugamCAConfig = mock(UgamCAConfig.class);
        lenient().when(ugamCAConfig.siteCountry()).thenReturn("US");
        lenient().when(ugamCAConfig.siteAdmin()).thenReturn("Chris");
        lenient().when(ugamCAConfig.siteSection()).thenReturn("US Section");
        currentPage = aemContext.create().page("/content/ugam/us/en");
        String currentPath = "/content/ugam/us/en";
        PrivateAccessor.setField(caConfig,"currentPage",currentPage);
        PrivateAccessor.setField(caConfig,"resourceResolver",resourceResolver);
        when(resourceResolver.getResource(currentPath)).thenReturn(contentResource);
        when(contentResource.adaptTo(ConfigurationBuilder.class)).thenReturn(configurationBuilder);
        when(configurationBuilder.as(UgamCAConfig.class)).thenReturn(ugamCAConfig);
        caConfig.postConstruct();
    }

    @Test
    void getSiteCountry() {
        assertEquals("US",caConfig.getSiteCountry());
    }

    @Test
    void getSiteAdmin() {
        assertEquals("Chris",caConfig.getSiteAdmin());
    }

    @Test
    void getSiteSection() {
        assertEquals("US Section",caConfig.getSiteSection());
    }

}