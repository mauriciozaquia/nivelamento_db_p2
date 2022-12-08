package Utilities;

import io.restassured.response.Response;

public class PropertiesSaver {
    public static void setValoresProperties(Response payLoad) {
        FileOperations.setProperties("ReturnOfGetCepValido", "cep", payLoad.body().path("cep"));
        FileOperations.setProperties("ReturnOfGetCepValido", "logradouro", payLoad.body().path("logradouro"));
        FileOperations.setProperties("ReturnOfGetCepValido", "complemento", payLoad.body().path("complemento"));
        FileOperations.setProperties("ReturnOfGetCepValido", "bairro", payLoad.body().path("bairro"));
        FileOperations.setProperties("ReturnOfGetCepValido", "localidade", payLoad.body().path("localidade"));
        FileOperations.setProperties("ReturnOfGetCepValido", "uf", payLoad.body().path("uf"));
        FileOperations.setProperties("ReturnOfGetCepValido", "ibge", payLoad.body().path("ibge"));
    }
}
