package com.enonic.plugin.thymeleafcontroller;

import com.enonic.cms.api.client.Client;
import com.enonic.cms.api.plugin.PluginConfig;
import com.enonic.cms.api.plugin.PluginEnvironment;
import com.enonic.cms.api.plugin.ext.http.HttpController;
import com.google.common.base.Strings;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


@Component
public class ThymeleafController extends HttpController {

    Logger LOG = LoggerFactory.getLogger(getClass());
    private final String interceptPath = "thymeleafcontroller";

    public ThymeleafController() {
        setDisplayName("Thymeleafcontroller");
        setUrlPatterns(new String[]{
                "/site/[0-999]/" + interceptPath +
                        ".*", "/admin/site/[0-999]/" + interceptPath + ".*"
        });
    }

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

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TemplateEngineProvider templateEngineProvider;


    /* START view methods
       methodName resolved by resolveMethodNameFromRequestPath() and called with reflection*/

    public void dothis(WebContext context) {
        context.setVariable("message", "dothis() method executed in ThymeleafController");
    }

    public void dothisAndthis(WebContext context) {
        context.setVariable("message", "dothisAndthis() method executed in ThymeleafController");
    }

    public void dothat(WebContext context) {
        context.setVariable("message", "dothat() method executed in ThymeleafController");
    }
    //END view methods

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //Set parameters on context to make them available in Thymeleaf html view
        WebContext context = new WebContext(request, response, request.getSession().getServletContext());

        String requestPath = StringUtils.substringAfterLast(request.getRequestURI(), "/" + interceptPath + "/");
        context.setVariable("requestPath", requestPath);
        context.setVariable("url", StringUtils.substringBeforeLast(request.getRequestURL().toString(), "/" + interceptPath));

        //Resolve methodname and call resolved method with reflection
        String methodName = resolveMethodNameFromRequestPath(requestPath);
        addRequestPathContext(methodName, context);

        response.setContentType("text/html");
        try {
            templateEngineProvider.setApplicationContext(applicationContext);
            templateEngineProvider.get().process(interceptPath, context, response.getWriter());
        } catch (Exception e) {
            LOG.error(e.getMessage());
            templateEngineProvider.get().process("errors/404", context, response.getWriter());
        }
    }

    /*
    * @param methodName - which method to call
    * @WebContext - send with context so method can set view specific parameters
    * */
    public void addRequestPathContext(String methodName, WebContext context) {
        if (Strings.isNullOrEmpty(methodName)) {
            return;
        }
        try {
            Method method = this.getClass().getMethod(methodName, WebContext.class);
            method.invoke(this, context);
        } catch (NoSuchMethodException e) {
            LOG.error("No method defined for requestPath {}, {}'", methodName, e);
        } catch (IllegalAccessException e) {
            LOG.error("IllegalAccessException with reflection {}", e);
        } catch (InvocationTargetException e) {
            LOG.error("InvocationTargetException with reflection {}", e.getTargetException());
        }
    }

    //Resolve method name from requestPath, example /dothis/andthis calls method dothisAndthis()
    public String resolveMethodNameFromRequestPath(String requestPath) {
        String[] words = requestPath.split("/");
        String methodName = "";
        for (String word : words) {
            methodName += StringUtils.capitalize(word.toLowerCase());
        }
        methodName = StringUtils.uncapitalize(methodName);

        return methodName;
    }
}
