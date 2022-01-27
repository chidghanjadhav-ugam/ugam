package com.ugam.core.models.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ugam.core.models.FetchAPI;
import com.ugam.core.models.UsersApiUrl;
import com.ugam.core.utils.Network;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Iterator;

@Model(adaptables = Resource.class,
        adapters = FetchAPI.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class FetchAPIImpl implements FetchAPI {
    final Logger LOG = LoggerFactory.getLogger(FetchAPIImpl.class);
    @Inject
    String url;

    @OSGiService
    UsersApiUrl usersApiUrl;
    private String message;
    private String email;
    private String firstname;
    private String lastname;
    private String image;

    @Override
    public String getData(){

        return usersApiUrl.getSingleUserUrl()+url;
    }
    @Override
    public String getMessage() throws JSONException, IOException {
        String response = Network.readJson(usersApiUrl.getSingleUserUrl()+url);
        JSONObject jsonObject =  new JSONObject(response);
        Iterator x = jsonObject.keys();
        JSONArray jsonArray = new JSONArray();
        while (x.hasNext()){
            String key = (String) x.next();
            jsonArray.put(jsonObject.get(key));
        }
        email = jsonArray.getJSONObject(0).getString("email");
        firstname = jsonArray.getJSONObject(0).getString("first_name");
        lastname = jsonArray.getJSONObject(0).getString("last_name");
        image = jsonArray.getJSONObject(0).getString("avatar");
        return response ;
    }
    @Override
    public String getFirstName(){
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getImage() {
        String original = image;
        String toreplace = "https://reqres.in/img/faces/";
        LOG.info("\n"+image);
        LOG.info("\n"+image.length());
        String replace = "/content/dam/ugam/";
        int position =original.indexOf(toreplace);
        LOG.info("\n"+position);
        int len = toreplace.length();
        String new_string = original.substring(0, position) + replace +
                original.substring(position+len);
        LOG.info("\n string"+new_string);
        return new_string;
    }

    @Override
    public String getEmail() {
        return email;
    }
}
