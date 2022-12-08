package testCases.viaCep;

import utilities.FileOperations;
import utilities.RequestTypes;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBases.CepInexistenteTestBase;

import static io.restassured.RestAssured.given;

public class TestsCepInexistente extends CepInexistenteTestBase {

    @Description("Consulta um CEP Inexistente")
    @DisplayName("Consulta CEP Inexistente")
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
