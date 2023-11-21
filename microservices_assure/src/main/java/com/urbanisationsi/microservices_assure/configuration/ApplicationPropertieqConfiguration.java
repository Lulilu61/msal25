package com.urbanisationsi.microservices_assure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("urbanisatiosi.clairprev")
@RefreshScope
public class ApplicationPropertieqConfiguration {
	
	private int limiteNombreAssure;

    public int getLimiteNombreAssure() {
        return limiteNombreAssure;
    }

    public void setLimiteNombreAssure(int limiteNombreAssure) {
        this.limiteNombreAssure = limiteNombreAssure;
    }

}
