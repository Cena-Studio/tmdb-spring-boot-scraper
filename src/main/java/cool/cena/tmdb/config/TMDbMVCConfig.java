package cool.cena.tmdb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cool.cena.tmdb.helper.TMDbConstraint;

@Configuration
public class TMDbMVCConfig implements WebMvcConfigurer{
    
    @Override
    public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
        registry.addResourceHandler(TMDbConstraint.IMG_FILE_PATH + "/*")
                .addResourceLocations("classpath:/static/r/img", "file:" + TMDbConstraint.IMG_FILE_DIR)
                .setCachePeriod(3600);
    }

}
