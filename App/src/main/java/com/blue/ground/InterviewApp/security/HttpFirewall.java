package com.blue.ground.InterviewApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.firewall.StrictHttpFirewall;

public class HttpFirewall {

    @Bean
    public StrictHttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }
}
