package com.ugam.core.models.impl;


import com.day.cq.commons.date.DateUtil;
import com.ugam.core.models.DateProperty;
import com.ugam.core.utils.ResolverUtil;
import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.Session;
import java.util.Calendar;

@Component(service = DateProperty.class, immediate = true)
public class DatePropertyImpl implements DateProperty {
    public static final Logger LOG = LoggerFactory.getLogger(DatePropertyImpl.class);
    @Reference
    ResourceResolverFactory resourceResolverFactory;

   String path = "/content/ugam/us/en/userlist/jcr:content/root/container/datetime";

    @Override
    public String addDate(String path) {
        try{
            LOG.info("Try Block");
            ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
            Session session = resourceResolver.adaptTo(Session.class);
            Resource resource = resourceResolver.getResource(path);
            LOG.info("Before Node");
            Node node = resource.adaptTo(Node.class);
            node.setProperty("date", DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance())));
            session.save();
            session.logout();
        }
        catch (Exception e){
            LOG.info(e.getMessage());
        }
        return path;
    }
}
