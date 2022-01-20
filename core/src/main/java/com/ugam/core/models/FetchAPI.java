package com.ugam.core.models;

import org.json.JSONException;

import java.io.IOException;

public interface FetchAPI {
    public String getData();
    public String getMessage() throws JSONException, IOException;
    public String getFirstName();
    public String getLastName();
    public String getImage();
    public String getEmail();
}
