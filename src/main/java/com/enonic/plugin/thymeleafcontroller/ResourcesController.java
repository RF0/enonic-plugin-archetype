package com.enonic.plugin.thymeleafcontroller;

import com.enonic.cms.api.plugin.ext.http.HttpController;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

@Component
public class ResourcesController extends HttpController{

    Logger LOG = LoggerFactory.getLogger(getClass());
    Map<String,String> supportedContentTypes = ImmutableMap.of("css","text/css","js","text/js","html","text/html","png","image/png");

    public ResourcesController() throws Exception {
        setDisplayName("Resources Controller");
        setUrlPatterns(new String[]{"/admin/site/[0-999].*_resources.*"});
        setPriority(9);
    }

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String fileName = StringUtils.substringAfterLast(request.getRequestURI(),"/");
        String fileType = StringUtils.substringAfterLast(request.getRequestURI(),".");

        if (Strings.isNullOrEmpty(fileName) || Strings.isNullOrEmpty(fileType)){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        LOG.info("Requested file {} in ResourceController", fileName);

        if (supportedContentTypes.containsKey(fileType)){
            response.setContentType(supportedContentTypes.get(fileType));
        }else{
            response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
            return;
        }
        stream(this.getClass().getResourceAsStream(fileName),response.getOutputStream());
    }



    public static long stream(InputStream input, OutputStream output) throws IOException {
        ReadableByteChannel inputChannel = null;
        WritableByteChannel outputChannel = null;

        try {
            inputChannel = Channels.newChannel(input);
            outputChannel = Channels.newChannel(output);
            ByteBuffer buffer = ByteBuffer.allocate(10240);
            long size = 0;

            while (inputChannel.read(buffer) != -1) {
                buffer.flip();
                size += outputChannel.write(buffer);
                buffer.clear();
            }

            return size;
        } finally {
            if (outputChannel != null) try {
                outputChannel.close();
            } catch (IOException ignore) { /**/ }
            if (inputChannel != null) try {
                inputChannel.close();
            } catch (IOException ignore) { /**/ }
        }
    }
}
