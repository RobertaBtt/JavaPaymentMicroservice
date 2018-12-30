package com.form3.payment.resource;

import io.katharsis.resource.registry.RegistryEntry;
import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.v3.KatharsisConfigV3;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Import({KatharsisConfigV3.class})
@Api(value = PaymentResource.PATH, description = "Payment operations")
public class PaymentResource {

    @Autowired
    private ResourceRegistry resourceRegistry;


    public static final String PATH = "/transactions/payments";

    @RequestMapping(PATH)
    public Map<String, String> getResources() {
        Map<String, String> result = new HashMap<>();
        // Add all resources
        for (RegistryEntry entry : resourceRegistry.getResources()) {
            result.put(entry.getResourceInformation().getResourceType(),
                    resourceRegistry.getResourceUrl(entry.getResourceInformation()));
        }

        return result;
    }


}
