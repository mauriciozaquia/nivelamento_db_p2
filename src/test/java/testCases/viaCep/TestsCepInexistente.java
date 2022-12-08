package testCases.viaCep;

import Utilities.FileOperations;
import Utilities.RequestTypes;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBase.CepInexistenteTestBase;

import static io.restassured.RestAssured.given;

public class TestsCepInexistente extends CepInexistenteTestBase {

    @Description("Consulta um CEP inexistente")
    @DisplayName("Consulta CEP inexistente")
    @Test
    public void getCepInexistente() {
        Response payLoad =
                given()
                        .spec(requestSpec)
                        .pathParam("cep", FileOperations.getProperties("cep").getProperty("cepInexistente"))
                .when()
                        .get("/{cep}/" + RequestTypes.getJson())
                .then()
                        .spec(responseSpec).extract().response();

        Assertions.assertEquals(true, payLoad.body().path("erro"));
    }

}
