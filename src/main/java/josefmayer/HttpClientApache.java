package josefmayer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

import java.net.URI;

/**
 * Created by Josef Mayer on 02.04.2017.
 */
public class HttpClientApache {

    public void printToFile(String requestMethod, URI uri, String pathname){
        HttpClient client = HttpClientBuilder.create().build();

        HttpRequestBase request = null;

        if (requestMethod.equals("GET")){
            request = new HttpGet(uri);
        } else if (requestMethod.equals("POST")) {
            request = new HttpPost(uri);
        } else if (requestMethod.equals("PUT")) {
            request = new HttpPut(uri);
        } else if (requestMethod.equals("DELETE")) {
            request = new HttpDelete(uri);
        }

        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader rd = null;
        try {
            rd = new BufferedReader
                    (new InputStreamReader(
                            response.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(pathname)));
        } catch (IOException e) {
            e.printStackTrace();
        }


        String line = "";
        try {
            while ((line = rd.readLine()) != null) {
                bw.write(line);
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
