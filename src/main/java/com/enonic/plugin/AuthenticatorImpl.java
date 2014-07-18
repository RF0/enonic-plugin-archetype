package com.enonic.plugin;

import com.enonic.cms.api.client.Client;
import com.enonic.cms.api.plugin.PluginConfig;
import com.enonic.cms.api.plugin.PluginEnvironment;
import com.enonic.cms.api.plugin.ext.auth.AuthenticationResult;
import com.enonic.cms.api.plugin.ext.auth.AuthenticationToken;
import com.enonic.cms.api.plugin.ext.auth.Authenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticatorImpl extends Authenticator {

    public AuthenticatorImpl(){
        setDisplayName("Example Authenticator implementation");
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
        //TODO: Temporary hack with List<PluginConfig> here
        this.pluginConfig = pluginConfig.get(0);
    }
    @Override
    public AuthenticationResult authenticate(AuthenticationToken authenticationToken) {
        LOG.info(getDisplayName());
        LOG.info("Username: {}", authenticationToken.getUserName());
        LOG.info("Userstore: {}", authenticationToken.getUserStore());
        LOG.info("Password: {}", authenticationToken.getPassword());

        return AuthenticationResult.OK;
    }
}
