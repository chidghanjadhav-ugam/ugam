package com.ugam.core.models;

public interface OSGIConfig {
    public String getServiceName();
    public int getCount();
    public boolean isDataLive();
    public String getRunModes();
}
