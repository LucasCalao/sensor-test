package eu.arrowhead.application.skeleton.consumer;

public class SensorConstants {

    //public static final String BASE_PACKAGE = "ai.aitia";
	
	public static final String CREATE_SENSOR_SERVICE_DEFINITION = "create-sensor";
	public static final String GET_SENSOR_SERVICE_DEFINITION = "get-sensor";
	public static final String INTERFACE_SECURE = "HTTP-SECURE-JSON";
	public static final String INTERFACE_INSECURE = "HTTP-INSECURE-JSON";
	public static final String HTTP_METHOD = "http-method";
	public static final String SENSOR_URI = "/sensor";
	public static final String BY_ID_PATH = "/{id}";
	public static final String PATH_VARIABLE_ID = "id";
	//public static final String REQUEST_PARAM_KEY_BRAND = "request-param-brand";
	//public static final String REQUEST_PARAM_BRAND = "brand";
	//public static final String REQUEST_PARAM_KEY_COLOR = "request-param-color";
	//public static final String REQUEST_PARAM_COLOR = "color";	
	
	//=================================================================================================
	// assistant methods

	//-------------------------------------------------------------------------------------------------
	private SensorConstants() {
		throw new UnsupportedOperationException();
	}
}
