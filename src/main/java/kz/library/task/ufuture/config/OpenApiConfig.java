package kz.library.task.ufuture.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "U-FUTURE"
                ),
                description = "OpenApi documentation for Ufuture",
                title = "OpenApi specification",
                version = "1.0",
                license = @License(
                        name = "Licence name"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8010/"
                ),
        }
)
public class OpenApiConfig {
}
