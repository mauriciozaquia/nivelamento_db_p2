package testCases.viaCep;

import utilities.FileOperations;
import utilities.RequestTypes;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import testBases.CepInvalidoTestBase;

import static io.restassured.RestAssured.given;

public class TestsCepInvalido extends CepInvalidoTestBase {

    @Description("Consulta um CEP Inválido")
    @DisplayName("Consulta CEP Inválido")
    @ParameterizedTest
    @ValueSource(strings = {"cepInvalido", "cepInvalidoEspaco", "cepInvalidoAlfanumerico"})
    public void getCepInvalido(String param)  {
        Response payLoad =
                given()
                        .spec(requestSpec)
                        .pathParam("cep", FileOperations.getProperties("cep").getProperty(param))
                .when()
                        .get("/{cep}/" + RequestTypes.getJson())
                .then()
                        .spec(responseSpec).extract().response();
    }

}
