package com.enonic.plugin;

import com.enonic.cms.api.plugin.ext.auth.AuthenticationResult;
import com.enonic.cms.api.plugin.ext.auth.AuthenticationToken;
import com.enonic.cms.api.plugin.ext.auth.Authenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatorExt extends Authenticator {

    public AuthenticatorExt(){
        setDisplayName("Example Authenticator extension");
        setPriority(0);
    }

    Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public AuthenticationResult authenticate(AuthenticationToken authenticationToken) {
        LOG.info(getDisplayName());
        LOG.info("Username: {}", authenticationToken.getUserName());
        LOG.info("Userstore: {}", authenticationToken.getUserStore());
        LOG.info("Password: {}", authenticationToken.getPassword());

        return AuthenticationResult.OK;
    }
}
