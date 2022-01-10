package com.ugam.core.models.impl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(AemContextExtension.class)
class OSGIConfigImplTest {
    private final AemContext aemContext = new AemContext();
    private OSGIConfigImpl osgiConfig;

    @BeforeEach
    void setUp() {
        osgiConfig = aemContext.registerService(new OSGIConfigImpl());
        OSGIConfigImpl.ServiceConfig config = mock(OSGIConfigImpl.ServiceConfig.class);
        when(config.serviceName()).thenReturn("OSGI Configuration");
        when(config.getCount()).thenReturn(1111);
        when(config.getDataLive()).thenReturn(true);
        when(config.getRunMode()).thenReturn("Author");
        osgiConfig.activate(config);
    }

    @Test
    void activate() {
    }

    @Test
    void getServiceName() {
        assertEquals("OSGI Configuration", osgiConfig.getServiceName());
    }

    @Test
    void getCount() {
        assertEquals(1111, osgiConfig.getCount());
    }

    @Test
    void isDataLive() {
        assertEquals(true, osgiConfig.isDataLive());
    }

    @Test
    void getRunModes() {
        assertEquals("Author", osgiConfig.getRunModes());
    }
}