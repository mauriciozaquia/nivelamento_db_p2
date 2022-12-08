package testCases.viaCep;

import utilities.FileOperations;
import utilities.PropertiesSaver;
import utilities.RequestTypes;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBases.CepValidoTestBase;

import static io.restassured.RestAssured.given;

public class TestsCepValido extends CepValidoTestBase {

    @Description("Consulta um CEP Válido")
    @DisplayName("Consulta CEP Válido")
    @Test
    public void getCepValido()  {
        Response payLoad =
                given()
                        .spec(requestSpec)
                        .pathParam("cep", FileOperations.getProperties("cep").getProperty("cepValido"))
                .when()
                        .get("/{cep}/" + RequestTypes.getJson())
                .then()
                        .spec(responseSpec).extract().response();
        ;

        String cepConsultado = FileOperations.getProperties("cep").getProperty("cepValido");
        String cepResposta = payLoad.then().extract().path("cep").toString().replaceAll("-", "");
        Assertions.assertEquals(cepConsultado, cepResposta);

        PropertiesSaver.setValoresProperties(payLoad);
    }

}
