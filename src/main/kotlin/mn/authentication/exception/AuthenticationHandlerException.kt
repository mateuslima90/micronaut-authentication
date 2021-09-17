package mn.authentication.exception

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Error
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.hateoas.JsonError
import io.micronaut.http.server.exceptions.ExceptionHandler
import javax.inject.Singleton

@Singleton
class AuthenticationHandlerException : ExceptionHandler<HttpClientResponseException, HttpResponse<*>> {

    @Error
    override fun handle(request: HttpRequest<*>, exception: HttpClientResponseException): MutableHttpResponse<*> {
        val error2 = exception.response.getBody(JsonError::class.java)


        val errorMessage = exception.response.body()

        return HttpResponse.badRequest("Error")
    }

    //HttpClientResponseException
}
