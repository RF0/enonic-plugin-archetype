package com.enonic.plugin;

import com.enonic.cms.api.client.Client;
import com.enonic.cms.api.plugin.PluginConfig;
import com.enonic.cms.api.plugin.PluginEnvironment;
import com.enonic.cms.api.plugin.ext.FunctionLibrary;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

@Component
public class FunctionLibraryImpl{

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

    public Document hello(String param1) throws Exception{
        LOG.info(param1);
        Document document = new Document(new Element("FunctionLibraryExample").setText(param1));

        //Example of 'pretty logging' to terminal
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        xmlOutputter.output(document, System.out);

        return document;
    }
}
