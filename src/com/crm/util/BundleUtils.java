package com.crm.util;

import java.util.ResourceBundle;

public class BundleUtils {
	
	public static String getString(String bundleName, String key) {

		ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
			String text = bundle.getString(key);
			return text;
	}
	
}
