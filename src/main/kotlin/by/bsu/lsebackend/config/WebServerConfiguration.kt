package by.bsu.lsebackend.config

import by.bsu.lsebackend.extension.empty
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

@Configuration
@EnableWebFlux
class WebServerConfiguration : WebFluxConfigurer {

    @Value("\${cors.origins}")
    private val corsOrigins: String = String.empty()

    override fun addCorsMappings(registry: CorsRegistry) {
        if (corsOrigins.isEmpty()) {
            throw IllegalArgumentException("Cors origin url is not provided.")
        }
        val allowedOrigins = corsOrigins.split(",").toTypedArray()
        registry.addMapping("/**")
            .allowedOrigins(*allowedOrigins)
            .allowedMethods("*")
            .allowedHeaders("*")
    }
}
