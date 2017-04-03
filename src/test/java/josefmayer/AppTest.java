package josefmayer;


import org.junit.Ignore;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;


public class AppTest {

    @Test
    public void testMethodGET() {
        System.out.println("#### testMethodGET ");

        String requestMethod = "GET";
        URI uri = null;
        try {
            uri = new URI("https://www.apache.org");
            //uri = new URI("http://127.0.0.1:8080/reverse?input=mytext");
            //uri = new URI("http://127.0.0.1:2222/home/param?name=josef");


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String pathname = new String("url_content_get.html");

        new HttpClientApache().printToFile(requestMethod, uri, pathname);

        //assertTrue(true);


    }

    @Ignore
    @Test
    public void testMethodPOST() {
        System.out.println("#### testMethodPOST ");

        String requestMethod = "POST";
        URI uri = null;
        try {

            uri = new URI("http://127.0.0.1:2222/home/post");

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String pathname = new String("url_content_post.html");

        new HttpClientApache().printToFile(requestMethod, uri, pathname);

        //assertTrue(true);


    }

    @Ignore
    @Test
    public void testMethodPUT() {
        System.out.println("#### testMethodPUT ");

        String requestMethod = "PUT";
        URI uri = null;
        try {
            uri = new URI("http://127.0.0.1:2222/home/HelloPut");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String pathname = new String("url_content_put.html");
        new HttpClientApache().printToFile(requestMethod, uri, pathname);

    }

    @Ignore
    @Test
    public void testMethodDELETE() {
        System.out.println("#### testMethodDELETE ");

        String requestMethod = "DELETE";
        URI uri = null;
        try {
            uri = new URI("http://127.0.0.1:2222/home/HelloDelete");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String pathname = new String("url_content_delete.html");
        new HttpClientApache().printToFile(requestMethod, uri, pathname);

    }
}



