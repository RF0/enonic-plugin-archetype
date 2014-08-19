package com.enonic.plugin;

import com.enonic.cms.api.client.Client;
import com.enonic.cms.api.plugin.PluginConfig;
import com.enonic.cms.api.plugin.PluginEnvironment;
import com.enonic.cms.api.plugin.ext.http.HttpInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class HttpInterceptorImpl extends HttpInterceptor {

    public HttpInterceptorImpl(){
        setDisplayName("Example HttpInterceptor implementation");
        setUrlPattern("/site/0/.*");
        setPriority(0);
    }

    Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    Client client;

    @Autowired
    PluginEnvironment pluginEnvironment;

    PluginConfig pluginConfig;
    @Autowired
    public void setPluginConfig(List<PluginConfig> pluginConfig) {
        //TODO: temporary necessary hack with List<PluginConfig> autowireing here
        this.pluginConfig = pluginConfig.get(0);
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.info(getDisplayName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }
}
