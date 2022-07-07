package transactionService

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class TransactionTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/transactions")
          .then()
             .statusCode(200)
             .body(`is`("Hello from RESTEasy Reactive"))
    }

}