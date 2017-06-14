package xyz.bookshop.utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Request {

    public static String execute(String method, String targetURL, String urlParameters, Map<String, String> headers) {
        HttpURLConnection connection = null;
        try {
            //Create connection
            URL url = new URL(targetURL);
//            Class classType = HttpURLConnection.class;
//            if (url.getProtocol().equalsIgnoreCase("https")) {
//                classType = HttpsURLConnection.class;
//            }

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);

            if (headers != null)
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            connection.setUseCaches(true);
            connection.setDoOutput(true);

            if (urlParameters!=null) {
                DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.close();
            }

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
//                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }


}
