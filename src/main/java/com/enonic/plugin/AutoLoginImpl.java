package com.enonic.plugin;

import com.enonic.cms.api.client.Client;
import com.enonic.cms.api.plugin.PluginConfig;
import com.enonic.cms.api.plugin.PluginEnvironment;
import com.enonic.cms.api.plugin.ext.http.HttpAutoLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class AutoLoginImpl extends HttpAutoLogin {

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

    public AutoLoginImpl(){
        setDisplayName("Example HttpAutoLogin implementation");
        setUrlPattern("/site/0/.*");
    }

    @Override
    public String getAuthenticatedUser(HttpServletRequest request) throws Exception {
        LOG.info(getDisplayName());
        LOG.info("Login admin on site 0");
        client.logout();
        //return "default\\username" //user USERSTORE\\USERNAME syntax except for admin/anonymous
        return "admin";
    }
}
