package com.niti;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.niti.rest.v1.resource.HealthCheck;
import com.niti.rest.v1.resource.UserExperienceResource;
import com.niti.rest.v1.resource.UserResource;
import com.niti.rest.v1.resource.exception.ApplicationExceptionMapper;

@Component
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		register(HealthCheck.class);
		register(UserResource.class);
		register(ApplicationExceptionMapper.class);
		register(UserExperienceResource.class);
	}
}
