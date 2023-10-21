package com.zhang.spring.resourceloaderaware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class TBean implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

   public String getText(String path){
        return resourceLoader.getResource(path).getFilename();

   }
}
