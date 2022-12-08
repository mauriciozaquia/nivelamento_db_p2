package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static utilities.Endpoints.BASE_URI;
import static utilities.Endpoints.PATH_WS;

public class CepRequestSpecification {

    public static RequestSpecification getCepRequestSpecification() {

        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(PATH_WS)
                .build();
    }

}
