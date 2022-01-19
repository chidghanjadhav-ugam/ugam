package com.ugam.core.models;

import org.json.JSONException;

import java.util.List;
import java.util.Map;

public interface UserListAPI {
    public List<Map<String,String>> getData() throws JSONException;
    public String getApiUrl();
}
