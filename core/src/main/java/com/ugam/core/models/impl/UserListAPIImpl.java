package com.ugam.core.models.impl;

import com.ugam.core.models.UserListAPI;
import com.ugam.core.utils.Network;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Model(adaptables = Resource.class,
        adapters = UserListAPI.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class UserListAPIImpl implements UserListAPI {
    final Logger log = LoggerFactory.getLogger(UserListAPIImpl.class);

    @Inject
    String pageNo;

    @Override
    public List<Map<String, String>> getData() throws JSONException {
        String response = Network.readJson(getApiUrl());
        log.info("\nresponse "+response);
        JSONObject jsonObject = new JSONObject(response);
        log.info("\nJson object "+jsonObject);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        log.info("\nJson Array "+jsonArray);

        List<Map<String,String>> userList = new ArrayList<>();
        for(int i=0; i<jsonArray.length(); i++){
            Map<String,String> user = new HashMap<>();
            user.put("firstname", jsonArray.getJSONObject(i).getString("first_name"));
            user.put("lastname", jsonArray.getJSONObject(i).getString("last_name"));
            user.put("email", jsonArray.getJSONObject(i).getString("email"));
            user.put("image", jsonArray.getJSONObject(i).getString("avatar"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public String getApiUrl() {
        return "https://reqres.in/api/users?page="+pageNo;
    }
}
