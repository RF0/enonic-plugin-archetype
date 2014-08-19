package com.enonic.plugin;

import com.enonic.cms.api.client.Client;
import com.enonic.cms.api.plugin.PluginConfig;
import com.enonic.cms.api.plugin.PluginEnvironment;
import com.enonic.cms.api.plugin.ext.TaskHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Properties;

/*
    Activated in Enonic Admin System->Job scheduler when
    ${cms.home}/config/cms.properties cms.scheduler.enabled=true
*/
@Component
public class TaskHandlerImpl extends TaskHandler {

   public TaskHandlerImpl(){
       setDisplayName("Example TaskHandler implementation");
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
    public void execute(Properties properties) throws Exception {
        LOG.info(getDisplayName());
        LOG.info("Executed scheduled task at {}", new Date());

    }
}
