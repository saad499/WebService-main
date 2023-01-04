package org.sid.banquerest;

import org.glassfish.jersey.server.ResourceConfig;
import org.sid.banquerest.web.CompteRestJaxRSApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

// pour le déploiement de jersey
@Configuration
public class MyConfig {
    //@Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet=new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRSApi.class);
        return jerseyServlet;
    }
   @Bean
    SimpleJaxWsServiceExporter serviceExporter(){
        SimpleJaxWsServiceExporter serviceExporter=new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://0.0.0.0:8087/");
        return serviceExporter;
    }


}
