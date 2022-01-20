package com.ugam.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "User Api Configuration")
public @interface UserApiConfig {

    @AttributeDefinition(
            name = "SingleUser Api Url",
            description = "Add Url for Single User",
            type = AttributeType.STRING)
    public String SingleUserUrl() default "https://reqres.in/api/users/";

    @AttributeDefinition(
            name = "ListUsers Api Url",
            description = "Add Url for List of User",
            type = AttributeType.STRING)
    public String ListUsersUrl() default "https://reqres.in/api/users?page=";
}
