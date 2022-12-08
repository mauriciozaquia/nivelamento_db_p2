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
import static org.hamcrest.Matchers.equalTo;

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

    @Description("Consulta um CEP válido - Exemplo validacao no .then")
    @DisplayName("Consulta CEP válido - Exemplo validacao no .then")
    @Test
    public void getCepValidoValidacaoNoThen()  {
        Response payLoad =
                given()
                        .spec(requestSpec)
                        .pathParam("cep", FileOperations.getProperties("cep").getProperty("cepValido"))
                        .when()
                        .get("/{cep}/" + RequestTypes.getJson())
                        .then()
                        .body("cep", equalTo("96200-003"))
                        .body("logradouro", equalTo("Rua Vinte e Quatro de Maio"))
                        .body("complemento", equalTo( "lado par"))
                        .body("bairro", equalTo( "Centro"))
                        .body("localidade", equalTo( "Rio Grande"))
                        .body("uf", equalTo( "RS"))
                        .body("ibge", equalTo( "4315602"))
                        .body("gia", equalTo( ""))
                        .body("ddd", equalTo( "53"))
                        .body("siafi", equalTo( "8815"))
                        .spec(responseSpec).extract().response();
        ;

        String cepConsultado = FileOperations.getProperties("cep").getProperty("cepValido");
        String cepResposta = payLoad.then().extract().path("cep").toString().replaceAll("-", "");
        Assertions.assertEquals(cepConsultado, cepResposta);

        PropertiesSaver.setValoresProperties(payLoad);
    }

}
