package com.sap.cloud.security.xsuaa.jwt;

public class JSONWebKeyConstants {

	public static final String BEGIN_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----";
	public static final String END_PUBLIC_KEY = "-----END PUBLIC KEY-----";
	public static final String KEYS_PARAMETER_NAME = "keys";

	// Parameter names as defined in https://tools.ietf.org/html/rfc7515#section-4
	public static final String KEY_TYPE_PARAMETER_NAME = "kty";
	public static final String ALGORITHM_PARAMETER_NAME = "alg";
	public static final String VALUE_PARAMETER_NAME = "value";
	public static final String KEY_ID_PARAMETER_NAME = "kid";
	public static final String KEYS_URL_PARAMETER_NAME = "jku";
}
