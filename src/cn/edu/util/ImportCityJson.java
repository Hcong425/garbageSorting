package cn.edu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.stream.JsonReader;

import cn.edu.rubbish.bean.Address;

public class ImportCityJson {

	public static Map<String, Map<String, String>> getMap() throws Exception {
		File file = new File("D:\\GoogleDownload\\jQueryDistpicker881120160621\\city.json");
		JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(file), "gbk"));
		jsonReader.setLenient(true);
		return readSheng(jsonReader);

	}

	public static Map<String, Map<String, String>> readSheng(JsonReader reader) throws Exception {
		Map<String, Map<String, String>> maps = new HashMap<String, Map<String, String>>();
		try {
			reader.beginObject();
			while (reader.hasNext()) {
				String key = reader.nextName();
				Map<String, String> map = new HashMap<String, String>();
				reader.beginObject();
				while (reader.hasNext()) {
					String shi = reader.nextName();
					String sheng = reader.nextString();
					map.put(shi, sheng);
				}
				maps.put(key, map);
				reader.endObject();

			}
			reader.endObject();
		} finally {
			reader.close();
		}
		maps = ImportCityJson.getMap();

		Map<String, String> shengmap = maps.get("86");
		for (Map.Entry<String, String> entry : shengmap.entrySet()) {
			String shengkey = entry.getKey();
			String sheng = entry.getValue();
			Address shengAddress = new Address(Integer.valueOf(shengkey), sheng, null, null);
			Set<Address> address1 = new HashSet<Address>();
			// System.out.println(sheng);
			// System.out.println("----------------------------------------------------");
			Map<String, String> shimap = maps.get(shengkey);
			if (shimap != null)
				for (Map.Entry<String, String> entry2 : shimap.entrySet()) {
					String shikey = entry2.getKey();
					String shi = entry2.getValue();
					Address shiAddress = new Address(Integer.valueOf(shikey), shi, null, shengAddress);
					Set<Address> address2 = new HashSet<Address>();
					// System.out.println(sheng);
					// System.out.println("
					// "+shi+"---------------------------------");
					Map<String, String> xianmap = maps.get(shikey);
					if (xianmap != null)
						for (Map.Entry<String, String> entry3 : xianmap.entrySet()) {
							String xiankey = entry3.getKey();
							String xian = entry3.getValue();
							Address xianAddress = new Address(Integer.valueOf(xiankey), xian, null, shiAddress);
							address2.add(xianAddress);

							// System.out.println(" "+xian);
						}
					shiAddress.setChildAddress(address2);
					address1.add(shiAddress);

				}
			shengAddress.setChildAddress(address1);

		}
		return maps;
	}

}