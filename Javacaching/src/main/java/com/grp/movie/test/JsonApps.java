package com.grp.movie.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Program: 4 Best ways to convert Java Map to JSONObject. Version: 1.0.0
 * 
 */

public class JsonApps {
	public static void main(String a[]) {

		Map<String, Object> requestMap = new LinkedHashMap<String, Object>();
		Map<String, Object> assetMap = new LinkedHashMap<String, Object>();
		Map<String, Object> metaDataMap = new LinkedHashMap<String, Object>();
		List<String> prdList = new ArrayList<String>();
		prdList.add("UK");
		prdList.add("US");
		prdList.add("SG");
		prdList.add("IN");
		metaDataMap.put("TCS", "Mumbai");
		metaDataMap.put("Infy", "Mysore");
		metaDataMap.put("Wipro", "Pune");
		metaDataMap.put("HCL", "Delhi");
		metaDataMap.put("Paypal", "Chennai");
		metaDataMap.put("M2List", prdList);

		requestMap.put("Google", "San Jose");
		requestMap.put("Facebook", "Mountain View");
		requestMap.put("Crunchify", "NYC");
		requestMap.put("Twitter", "SFO");
		requestMap.put("Microsoft", "Seattle");

		requestMap.put("M1List", prdList);
		requestMap.put("M3Map", metaDataMap);
		log("Raw Map ===> " + requestMap);

		// Use this builder to construct a Gson instance when you need to set
		// configuration options other than the default.
		GsonBuilder gsonMapBuilder = new GsonBuilder();

		Gson gsonObject = gsonMapBuilder.create();

		String JSONObject = gsonObject.toJson(requestMap);
		log("\nMethod-1: Using Google GSON ==> " + JSONObject);

		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(requestMap);

		log("\nPretty JSONObject ==> " + prettyJson);

		// Construct a JSONObject from a Map.
		org.json.JSONObject crunchifyObject = new JSONObject(requestMap);
		log("\nMethod-2: Using new JSONObject() ==> " + crunchifyObject);

		try {
			// Default constructor, which will construct the default JsonFactory
			// as necessary, use SerializerProvider as its
			// SerializerProvider, and BeanSerializerFactory as its
			// SerializerFactory.
			String objectMapper = new ObjectMapper().writeValueAsString(requestMap);
			log("\nMethod-3: Using ObjectMapper().writeValueAsString() ==> " + objectMapper);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// Convert an object to JSON text. If this object is a Map or a List,
		// and it's also a JSONAware, JSONAware will be considered firstly.
		String jsonValue = JSONValue.toJSONString(requestMap);
		log("\nMethod-4: Using JSONValue.toJSONString() ==> " + jsonValue);
		requestMap.clear();
		prdList.clear();
		metaDataMap.clear();
		prdList.add("BKI");
		prdList.add("NGACCINFO");

		metaDataMap.put("appid", "gtb-api");
		metaDataMap.put("policydef", "psd2");
		metaDataMap.put("policypermission", "read");
		metaDataMap.put("transref", "req-1234567890");
		metaDataMap.put("webssoid", "abc.def@yddc.com");
		metaDataMap.put("prdlist", prdList);
		metaDataMap.put("mandateid", "abc@db.eu");
		metaDataMap.put("asset", assetMap);
		requestMap.put("iban", "DE12345678901");
		requestMap.put("roleType", "E");
		requestMap.put("status", "Y");
		requestMap.put("mandateType", "DBDI");
		requestMap.put("bicCode", "DEXXXXXXXX");
		assetMap.put("assetLevel", "MandateLvl");
		assetMap.put("account", requestMap);
		metaDataMap.put("asset", assetMap);

		log("Raw Map ===> " + metaDataMap);
		JSONObject = gsonObject.toJson(metaDataMap);
		log("\nMethod-1: Using Google GSON ==> " + JSONObject);

		prettyGson = new GsonBuilder().setPrettyPrinting().create();
		prettyJson = prettyGson.toJson(metaDataMap);

		log("\nPretty JSONObject ==> " + prettyJson);

		// Construct a JSONObject from a Map.
		crunchifyObject = new JSONObject(metaDataMap);
		log("\nMethod-2: Using new JSONObject() ==> " + crunchifyObject);

		try {
			// Default constructor, which will construct the default JsonFactory
			// as necessary, use SerializerProvider as its
			// SerializerProvider, and BeanSerializerFactory as its
			// SerializerFactory.
			String objectMapper = new ObjectMapper().writeValueAsString(metaDataMap);
			log("\nMethod-3: Using ObjectMapper().writeValueAsString() ==> " + objectMapper);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// Convert an object to JSON text. If this object is a Map or a List,
		// and it's also a JSONAware, JSONAware will be considered firstly.
		jsonValue = JSONValue.toJSONString(metaDataMap);
		log("\nMethod-4: Using JSONValue.toJSONString() ==> " + jsonValue);

		Map<String, Object> map = new LinkedHashMap<String, Object>();

		Map<String, Object> retMap = new Gson().fromJson(jsonValue, new TypeToken<LinkedHashMap<String, Object>>() {
		}.getType());
		System.out.println("Gson String to map :---" + retMap);

		System.out.println("JsonUtils String to map :---" + JsonUtils.jsonToMap(crunchifyObject));

		ObjectMapper mapper = new ObjectMapper();
		try {
			// Convert Map to JSON
			map = mapper.readValue(crunchifyObject.toString(), new TypeReference<Map<String, Object>>() {
			});

			// Print JSON output
			System.out.println("String to map :---" + map);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void log(Object print) {
		System.out.println(print);

	}
}