package com.enonic.plugin;

import com.enonic.cms.api.client.Client;
import com.enonic.cms.api.plugin.PluginConfig;
import com.enonic.cms.api.plugin.PluginEnvironment;
import org.jdom.Document;
import org.jdom.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*
 Configured in resources/META-INF/spring/context.xml

 Call from invokeExtension DS
 https://enonic.com/en/docs/enonic-cms-47?page=Util+datasources#Utildatasources-invokeExtension
 <datasources>
  <datasource name="invokeExtension">
    <parameter name="name">example.hello</parameter>
    <parameter name="param1">Say Hello!</parameter>
  </datasource>
</datasources>
*/

public class FunctionLibraryExt {

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

    public Document hello(String param1) {
        LOG.info(param1);
        return new Document(new Element("FunctionLibraryExample").setText(param1));
    }
}
