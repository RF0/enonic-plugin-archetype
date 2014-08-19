package com.enonic.plugin;

import com.enonic.cms.api.client.Client;
import com.enonic.cms.api.plugin.PluginConfig;
import com.enonic.cms.api.plugin.PluginEnvironment;
import com.enonic.cms.api.plugin.ext.http.HttpResponseFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class ResponseFilterImpl extends HttpResponseFilter {

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

    public ResponseFilterImpl(){
        setDisplayName("Example HttpResponseFilter implementation");
        setUrlPattern("/site/0/.*");
    }

    @Override
    public String filterResponse(HttpServletRequest request, String response, String contenttype) throws Exception {
        LOG.info(getDisplayName());

        if (contenttype.contains("text/html")){
            response = response.replaceAll("##user##", client.getUserName());
        }
        return response;
    }
}
