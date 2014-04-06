package com.redhat.mailinglistOnline.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Util {

	public static List<Map.Entry<?, ?>> toList(Map<?, ?> map) {
	    return map != null ? new ArrayList<Map.Entry<?,?>>(map.entrySet()) : null;
	}
}
