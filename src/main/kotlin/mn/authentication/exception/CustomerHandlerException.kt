package mn.authentication.exception

import io.micronaut.context.annotation.Requirements
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import mn.authentication.model.CustomerResponse
import javax.inject.Singleton
//
//@Produces
//@Singleton
//@Requirements(Requires(classes = [CustomerException::class, ExceptionHandler::class]))
//class CustomerExceptionHandler : ExceptionHandler<CustomerException, HttpResponse<*>> {
//
//    override fun handle(request: HttpRequest<*>, exception: CustomerException): MutableHttpResponse<*> {
//        return HttpResponse.badRequest(CustomerResponse(mapError(exception.localizedMessage)))
//    }
//
//    private fun mapError(error: String): String {
//       return when(error){
//            "Conflict" -> "User exists with same username or email"
//           else -> "Error"
//       }
//    }
//}