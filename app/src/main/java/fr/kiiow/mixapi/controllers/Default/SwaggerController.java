package fr.kiiow.mixapi.controllers.Default;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/swagger-ui")
public class SwaggerController {

    @Value("classpath:swagger-ui/swagger-dark-ui.css")
    private Resource darkThemeCss;

    @Value("classpath:/META-INF/resources/webjars/swagger-ui/5.13.0/swagger-ui.css")
    private Resource originalCss;

    @Hidden
    @GetMapping(path="/swagger-ui.css", produces = "text/css")
    public String getCss() throws IOException {
        return toText(originalCss.getInputStream()) + toText(darkThemeCss.getInputStream());
    }

    static String toText(InputStream in) {
        return new BufferedReader( new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines().collect(Collectors.joining("\n"));
    }
}