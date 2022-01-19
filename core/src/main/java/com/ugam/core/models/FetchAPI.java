package com.ugam.core.models;

import org.json.JSONException;

public interface FetchAPI {
    public String getData();
    public String getMessage() throws JSONException;
    public String getFirstName();
    public String getLastName();
    public String getImage();
    public String getEmail();
}
