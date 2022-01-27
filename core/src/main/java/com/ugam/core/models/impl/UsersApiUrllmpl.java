package com.ugam.core.models.impl;

import com.ugam.core.config.UserApiConfig;
import com.ugam.core.models.UsersApiUrl;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = UsersApiUrl.class,immediate = true)
@Designate(ocd = UserApiConfig.class)
public class UsersApiUrllmpl implements UsersApiUrl {
    final Logger log = LoggerFactory.getLogger(UsersApiUrllmpl.class);
    String singleuserurl;
    String userlisturl;

    @Activate
    public void activate(UserApiConfig userApiConfig){
        singleuserurl = userApiConfig.SingleUserUrl();
        userlisturl = userApiConfig.ListUsersUrl();
    }
    @Override
    public String getSingleUserUrl() {
        log.info(singleuserurl);
        return singleuserurl;
    }

    @Override
    public String getListUsersUrl() {
        log.info((userlisturl));
        return userlisturl;
    }
}
