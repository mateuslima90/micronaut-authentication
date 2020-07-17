package mn.authentication.configuration

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties(IdpConfiguration.PREFIX)
class IdpConfiguration {

    companion object {
        const val PREFIX = "idp"
        const val IDP_URL = "http://127.0.0.1:8080"
    }

}