package mn.authentication

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("mn.authentication")
                .mainClass(Application.javaClass)
                .start()
    }
}