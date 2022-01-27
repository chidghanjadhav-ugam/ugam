package com.ugam.core.utils;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Network {
    static final Logger LOG = LoggerFactory.getLogger(Network.class);
    private static final String USER_AGENT = "Chrome/97.0.4692.71";

    public static String readJson(String url) throws JSONException, IOException {

        URL requestURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();
        String inputLine;
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", USER_AGENT);
        conn.connect();
        LOG.info("connection done");
        int responsecode = conn.getResponseCode();
        LOG.info(String.valueOf(responsecode));
        if (responsecode == 200) {
            LOG.info("inside if");
            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
            }
            LOG.info(response.toString());
            input.close();
            return response.toString();
        } else {
            LOG.info("HttpResponseCode: " + responsecode);
        }
        return "Network Failed";
    }
}
