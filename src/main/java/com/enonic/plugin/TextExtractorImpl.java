package com.enonic.plugin;

import com.enonic.cms.api.plugin.ext.TextExtractor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class TextExtractorImpl extends TextExtractor {

    @Override
    public boolean canHandle(String s) {
        return false;
    }

    @Override
    public String extractText(String s, InputStream inputStream, String s2) throws IOException {
        return null;
    }
}
