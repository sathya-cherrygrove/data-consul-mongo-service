package com.sat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConsulController {

	@Autowired
	private DiscoveryClient discoveryclient;

	@RequestMapping("/listservices")
	public String displayServices() {
		String serviceUrl = null;
		List<ServiceInstance> serviceinstances = discoveryclient.getInstances("dataservice");
		for (ServiceInstance service : serviceinstances) {
			serviceUrl = service.getUri().toString();
		}

		return serviceUrl;
	}

	@RequestMapping("/healthCheck")
	public String healthCheck() {

		return "Service1 is running correctly";

	}
	
	@RequestMapping("/insertData")
	public String insertdata()
	{
		return "Data insertion";
	}

}
