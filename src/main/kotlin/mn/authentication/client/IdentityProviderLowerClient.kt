package mn.authentication.client

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriTemplate
import io.reactivex.Flowable
import mn.authentication.configuration.IdpConfiguration
import mn.authentication.model.Customer
import mn.authentication.model.IdentityProvider
import mn.authentication.model.IdentityProviderResponse
import javax.inject.Singleton

@Singleton
class IdentityProviderLowerClient(@param:Client(IdpConfiguration.IDP_URL) private val http: RxHttpClient) {

    internal fun authenticate(identityProvider: IdentityProvider): Flowable<HttpResponse<IdentityProviderResponse>> {

        val path = "/auth/realms/master/protocol/openid-connect/token"
        val uri = UriTemplate.of(path).toString()


        val request = HttpRequest.POST(uri, identityProvider)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)

        return http.exchange(request, IdentityProviderResponse::class.java)

    }

    internal fun signup(customer: Customer, authorization: String): Flowable<Int> {

        val path = "/auth/admin/realms/customer/users"

        val request = HttpRequest.POST(path, customer)
                .header("Authorization", authorization)

        return http.exchange(request, Customer::class.java)
                .map { response -> response.code() }
    }
}