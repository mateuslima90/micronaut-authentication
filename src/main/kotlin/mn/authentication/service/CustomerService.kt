package mn.authentication.service

import mn.authentication.client.IdentityProviderClient
import mn.authentication.client.IdentityProviderLowerClient
import mn.authentication.exception.CustomerException
import mn.authentication.model.*
import reactor.core.publisher.Mono
import javax.inject.Singleton

@Singleton
class CustomerService(val identityProviderLowerClient: IdentityProviderLowerClient,
                      val idpClient: IdentityProviderClient) {


//    fun signup(customer: Customer): Mono<CustomerReponse> {
//        return identityProviderLowerClient.authenticate(IdentityProvider("admin", "admin", "password", "admin-cli"))
//                .map { identity -> identity.body()!!.access_token }
//                .flatMap { token -> identityProviderLowerClient.signup(customer, "Bearer ".plus(token)) }
//                .map { CustomerReponse(true)  }
//
//    }

    fun authenticate(): Mono<IdentityProviderResponse> {
        return idpClient.authenticate(IdentityProvider("admin", "admin", "password", "admin-cli"))
    }

    fun signup2(customer: Customer) : Mono<Void> {
        return idpClient.authenticate(IdentityProvider("admin", "admin", "password", "admin-cli"))
                .map { response -> "Bearer ".plus(response.access_token) }
                .flatMap { token -> idpClient.signup(token, makingUser(customer)) }
                .doOnError { t -> print(t.stackTrace) }
                .onErrorResume { t -> Mono.error(CustomerException(t.message!!)) }
    }

    fun makingUser(customer: Customer) : IdpUser {
        val credentials : List<Credential> = listOf(Credential("password", customer.password))

        return IdpUser(customer.username, customer.email, true, credentials)
    }

}