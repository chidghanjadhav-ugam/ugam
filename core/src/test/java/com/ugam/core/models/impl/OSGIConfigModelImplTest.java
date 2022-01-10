package com.ugam.core.models.impl;

import com.ugam.core.models.OSGIConfig;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class OSGIConfigModelImplTest {
    AemContext aemContext = new AemContext();
    OSGIConfigImpl osgiConfig;
    private String serviceName;
    private int count;
    private boolean dataLive;
    private String runModes;

    @BeforeEach
    void setUp() {
        osgiConfig = aemContext.registerService(new OSGIConfigImpl());
        OSGIConfigImpl.ServiceConfig osgiConfig1 = mock(OSGIConfigImpl.ServiceConfig.class);
        when(osgiConfig1.serviceName()).thenReturn("OSGI Configuration");
        when(osgiConfig1.getCount()).thenReturn(1111);
        when(osgiConfig1.getDataLive()).thenReturn(true);
        when(osgiConfig1.getRunMode()).thenReturn("Author");
        osgiConfig.activate(osgiConfig1);
    }

    @Test
    void getServiceName() {
        OSGIConfigModelImpl osgiConfigModel = aemContext.request().adaptTo(OSGIConfigModelImpl.class);
        assertEquals("OSGI Configuration", osgiConfigModel.getServiceName());
    }

    @Test
    void getCount() {
        OSGIConfigModelImpl osgiConfigModel = aemContext.request().adaptTo(OSGIConfigModelImpl.class);
        assertEquals(1111, osgiConfigModel.getCount());
    }

    @Test
    void isDataLive() {
        OSGIConfigModelImpl osgiConfigModel = aemContext.request().adaptTo(OSGIConfigModelImpl.class);
        assertEquals(true, osgiConfigModel.isDataLive());
    }

    @Test
    void getRunModes() {
        OSGIConfigModelImpl osgiConfigModel = aemContext.request().adaptTo(OSGIConfigModelImpl.class);
        assertEquals("Author", osgiConfigModel.getRunModes());
    }
}