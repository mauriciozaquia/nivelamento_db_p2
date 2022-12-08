package Utilities;

public class Endpoints {

    protected static final String BASE_URI = FileOperations.getProperties("Environment").getProperty("baseUri");

    protected static final String PATH_WS = FileOperations.getProperties("Environment").getProperty("ws");
}
