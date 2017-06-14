package xyz.bookshop.utils;

import net.sf.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

/**
 * Created by moyu on 2017/6/14.
 */
public class Convert {
    public static String yaml2JSON(String yamlStr) {
        Yaml yaml = new Yaml();
        Map<String, Object> map = (Map<String, Object>) yaml.load(yamlStr);
        JSONObject json = new JSONObject();
        json.putAll(map);
        return json.toString();
    }

    public static String yaml2JSON(InputStream inputStream) {
        Yaml yaml = new Yaml();
        Map<String, Object> map = (Map<String, Object>) yaml.load(inputStream);
        JSONObject json = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
            json.put(entry.getKey(), entry.getValue());
        }
        return json.toString();
    }

    public static String yaml2JSON(Reader reader) {
        Yaml yaml = new Yaml();
        Map<String, Object> map = (Map<String, Object>) yaml.load(reader);
        JSONObject json = new JSONObject();
        json.putAll(map);
        return json.toString();
    }
}
