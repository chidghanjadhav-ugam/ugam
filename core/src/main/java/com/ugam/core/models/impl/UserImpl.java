package com.ugam.core.models.impl;


import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugam.core.models.Users;

import com.ugam.core.utils.ResolverUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Users.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserImpl implements Users{
    private static final Logger LOG = LoggerFactory.getLogger(UserImpl.class);

    @Inject
    ResourceResolver resolver;
    @Inject
    QueryBuilder queryBuilder;

    @Override
    public String getUsernames() {
        LOG.info("\n Log from class!!");

        String user="";

        List<String> usernames = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:User");
        userMap.put("path", "/home/users");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");
        try {
            LOG.info("\n Log From Try");
            Session session = resolver.adaptTo(Session.class);
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            SearchResult result = userQuery.getResult();
            List<Hit> Hits = result.getHits();
            for (Hit hit : Hits) {
                user = user + "\r\n" + hit.getProperties().get("rep:principalName", String.class);
            }
        } catch (Exception e) {
            LOG.info("\n ERROR",e.getMessage());
        }
        return user;
    }

}
