package com.mobile.appium;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ReadFromJson {

	/**
	 * Reads JSON config and returns desired capabilities
	 * 
	 * @param configFilePath
	 * @return
	 */
	public static DesiredCapabilities readCapabilities(String configFilePath) {
		JSONParser parser = new JSONParser();
		DesiredCapabilities capabilities = null;
		try {
			Object obj = parser.parse(new FileReader(configFilePath));
			JSONObject jo = (JSONObject) obj;
			Map address = ((Map) jo.get("caps"));
			capabilities = new DesiredCapabilities();
			// iterating Map
			Iterator<Map.Entry> itr1 = address.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				System.out.println(pair.getKey() + " : " + pair.getValue());
				capabilities.setCapability((String) pair.getKey(), pair.getValue());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return capabilities;
	}

	/**
	 * Reads a key and returns value from the JSON file
	 * 
	 * @param configFilePath
	 * @param key
	 * @return
	 */
	public static String readKey(String configFilePath, String key) {
		JSONParser parser = new JSONParser();
		String value = null;
		try {
			Object obj = parser.parse(new FileReader(configFilePath));
			JSONObject jo = (JSONObject) obj;
			value = (String) jo.get(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return value;
	}
}
