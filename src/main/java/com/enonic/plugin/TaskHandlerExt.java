package com.enonic.plugin;

import com.enonic.cms.api.plugin.ext.TaskHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Properties;

/*
    Activated in Enonic Admin System->Job scheduler when
    ${cms.home}/config/cms.properties cms.scheduler.enabled=true
*/
@Component
public class TaskHandlerExt extends TaskHandler {

   public TaskHandlerExt(){
       setDisplayName("Example TaskHandler extension");
   }

    Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Properties properties) throws Exception {
        LOG.info(getDisplayName());
        LOG.info("Executed scheduled task at {}", new Date());

    }
}
