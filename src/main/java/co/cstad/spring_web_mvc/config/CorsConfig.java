package co.cstad.spring_web_mvc.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                origin is the url that is allowed to access the resource fronted by the server
                .allowedOrigins("http://127.0.0.1:5500");
    }
}
