package fr.kiiow.mixapi.controllers.security;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Authentication", description = "Authentication functionality")
@RequestMapping(value = "auth")
public interface IAuthenticationController {
}
