package com.ugam.core.models.impl;


import com.day.cq.commons.date.DateUtil;
import com.day.cq.replication.*;
import com.ugam.core.models.DateProperty;
import com.ugam.core.utils.ResolverUtil;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.Session;
import java.util.Calendar;

@Component(immediate = true)
public class UgamPreprocessor implements Preprocessor {
    public static final Logger LOG = LoggerFactory.getLogger(UgamPreprocessor.class);

    @Reference
    DateProperty dateProperty;

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    String path1 = "/content/ugam/us/en/userlist/jcr:content/root/container/datetime";

    @Override
    public void preprocess(ReplicationAction replicationAction, ReplicationOptions replicationOptions) throws ReplicationException {
        LOG.info("\nInside Method");
        if (replicationAction == null || !ReplicationActionType.ACTIVATE.equals(replicationAction.getType())) {
            return;
        }
        String path = replicationAction.getPath();
        if(path.equals("/content/ugam/us/en/userlist")){
            LOG.debug("\npath equal");
            try {
                ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
                Session session = resourceResolver.adaptTo(Session.class);
                Resource resource = resourceResolver.getResource(dateProperty.addDate(path1));
                Node node = resource.adaptTo(Node.class);
                Property date = node.getProperty("date");
                if(date == DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance()))){
                    LOG.info("\nInside IF");
                }else{
                    LOG.info("\nInside Else");
                    dateProperty.addDate(path1);
                    session.save();
                    session.logout();
                }
                LOG.debug(path);
            } catch (Exception e) {
                LOG.info(e.getMessage());
            }
        }

    }
}
