package mn.authentication.model

import io.micronaut.core.annotation.Introspected
import jdk.jfr.Enabled

//@Introspected
data class IdentityProvider(val username: String? = null,
                            val password: String? = null,
                            val grant_type: String? = null,
                            val client_id: String? = null)


data class IdentityProviderResponse(val access_token: String? = null,
                                    val expires_in: Int? = null,
                                    val refresh_expires_in: Int? = null,
                                    val refresh_token: String? = null,
                                    val token_type: String? = null,
                                    val session_state: String? = null,
                                    val scope: String? = null)

data class Customer(val username: String? = null,
                    val email: String? = null,
                    val password: String? = null)

data class CustomerReponse(val response: Boolean)

data class Credential(val type: String? = null,
                      val value: String? = null)

data class IdpUser(val username: String? = null,
                   val email: String? = null,
                   val enabled: Boolean? = null,
                   val credentials: List<Credential>)

data class CustomerResponse(val msg: String)