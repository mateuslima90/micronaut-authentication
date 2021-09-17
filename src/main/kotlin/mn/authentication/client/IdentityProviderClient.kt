package mn.authentication.client

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import mn.authentication.model.*
import reactor.core.publisher.Mono


@Client(id = "idp-client")
interface IdentityProviderClient {

    @Post("/auth/realms/master/protocol/openid-connect/token")
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    fun authenticate(@Body identityProvider: IdentityProvider) : Mono<IdentityProviderResponse>

    @Post("/auth/realms/customer/protocol/openid-connect/token")
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    fun customerAuthenticate(@Body customerAuthRequest: CustomerAuthRequest) : Mono<IdentityProviderResponse>

    //@Status(HttpStatus.NO_CONTENT)
    @Post("/auth/admin/realms/customer/users")
    fun signup(@Header("Authorization") authorization: String,
               @Body idpUser: IdpUser) : Mono<Void>
}