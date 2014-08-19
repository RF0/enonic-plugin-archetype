package com.enonic.plugin;

import com.enonic.cms.api.client.Client;
import com.enonic.cms.api.plugin.PluginConfig;
import com.enonic.cms.api.plugin.PluginEnvironment;
import com.enonic.cms.api.plugin.ext.http.HttpController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;

@Component
public class HttpControllerImpl extends HttpController{

    File resourcesFile;

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
        resourcesFile = new File(this.pluginConfig.getString("resourcesFile"));
    }

    public HttpControllerImpl(){
        setDisplayName("Example HttpController implementation");
        setUrlPatterns(new String[]{"/site/0/httpcontroller","/site/0/httpcontroller2"});
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOG.info(getDisplayName());
        PrintWriter out = response.getWriter();
        out.write(resourcesFile.getAbsolutePath());
        out.close();
    }
}
