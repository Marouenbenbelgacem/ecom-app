package org.sid.billing.controllers;

import org.sid.billing.controllers.config.MyConsulConfiguration;
import org.sid.billing.controllers.config.MyVaultConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RefreshScope //refresher la configuration chaque fois ça change
public class ConsulConfigRestController {

    @Autowired
    private MyConsulConfiguration myConsulConfiguration;

    @Autowired
    private MyVaultConfiguration myVaultConfiguration;

    //The "@Value" annotation is used to assign a value to a field from a property defined in a configuration file,
   /* @Value("${token.accessTokenTimeout}")
    private Long accessTokenTimeout;
    @Value("${token.refreshTokenTimeout}")
    private Long refreshTokenTimeout;*/

   /* @GetMapping("/myconfig")
    public Map<String, Object> myConfig (){

        return Map.of("token.accessTokenTimeout", accessTokenTimeout, "token.refreshTokenTimeout",refreshTokenTimeout);


    }*/

    @GetMapping("/myconfig")
    public Map<String, Object> myConfig() {

        return Map.of("myConsulConfiguration", myConsulConfiguration,
                "myVaultConfiguration", myVaultConfiguration);

    }
}
