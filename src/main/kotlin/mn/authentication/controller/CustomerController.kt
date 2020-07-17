package mn.authentication.controller

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import mn.authentication.model.Customer
import mn.authentication.model.IdentityProviderResponse
import mn.authentication.service.CustomerService
import reactor.core.publisher.Mono

@Controller
class CustomerController(val customerService: CustomerService) {

//    @Post("/signup")
//    fun signup(customer: Customer): Mono<CustomerReponse> {
//        return customerService.signup(customer)
//                .map { customer -> customer }
//    }

    @Post("/authenticate")
    fun authenticate() : Mono<IdentityProviderResponse> {
        return customerService.authenticate()
    }


    @Status(HttpStatus.NO_CONTENT)
    @Post("/signup2")
    fun signup2(customer: Customer): Mono<Void> {
        return customerService.signup2(customer)
    }

}