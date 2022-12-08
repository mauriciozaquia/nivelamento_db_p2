package viaCep;

import Utilities.FileOperations;
import Utilities.PropertiesSaver;
import Utilities.RequestTypes;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testBase.CepValidoTestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetCepValido extends CepValidoTestBase {

    @Description("Consulta um CEP válido")
    @DisplayName("Consulta CEP válido")
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
