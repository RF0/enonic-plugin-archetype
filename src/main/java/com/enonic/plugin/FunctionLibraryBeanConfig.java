package com.enonic.plugin;

import com.enonic.cms.api.plugin.ext.FunctionLibrary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rfo on 19/08/14.
 */
@Configuration
public class FunctionLibraryBeanConfig {

    @Bean
    public FunctionLibrary createConfig(FunctionLibraryImpl target){
        FunctionLibrary functionLibrary = new FunctionLibrary();
        functionLibrary.setDisplayName("Example FunctionLibrary extension");
        functionLibrary.setTarget(target);
        functionLibrary.setName("example");
        return functionLibrary;
    }
}
