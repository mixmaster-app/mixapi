package fr.kiiow.mixapi.controllers.security;

import fr.kiiow.mixapi.controllers.ISecurityController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/auth")
@Tag(name = "Authentication", description = "Authentication functionality")
public interface IAuthenticationController extends ISecurityController {
}
