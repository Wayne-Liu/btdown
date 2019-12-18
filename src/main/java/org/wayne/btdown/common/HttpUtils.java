package org.wayne.btdown.common;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.toJSONString;
import static org.wayne.btdown.common.SleepUtils.sleep;

public class HttpUtils {
    private static final long SLEEP_DURATION_BEFORE_PRINTING_RETURNED_CONTENT = 2000;
    public static final Logger LOGGER = LoggerFactory.getLogger("");
    public static Header auth_token = new BasicHeader("authtoken", "");

    private HttpUtils() {
    }

    @SuppressWarnings("unused")
    private static void ___________________________________________GET___________________________________________() {
    }

    @SafeVarargs
    public static String httpGetKeyValuePairsWithCookiesAndHeaders(String httpApi,
                                                                   List<Cookie> cookies,
                                                                   List<Header> headers,
                                                                   boolean checkReturnCode,
                                                                   Map.Entry<String, String>... keyValuePairs) {

        LOGGER.info("================================httpRequestInfo.head====================================================================");
        LOGGER.info("httpGetKeyValuePairsWithCookiesAndHeaders:");
        LOGGER.info("httpApi: \n{}", httpApi);
        LOGGER.info("keyValuePairs: \n{}", toJSONString(keyValuePairs, true));
        LOGGER.info("cookies: \n{}", toJSONString(cookies, true));

        HttpClient httpClient;
        HttpGet httpGet = null;

        try {

            if (cookies == null) {

                httpClient = HttpClients.createDefault();

            } else {

                //@formatter:off
                BasicCookieStore cookieStore = new BasicCookieStore() {{
                    addCookies(cookies.toArray(new Cookie[0]));
                }};
                //@formatter:on

                httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

            }

            httpGet = new HttpGet(populateUrlWithValuesEncoded(httpApi, keyValuePairs));

            if (headers != null) {
                for (Header header : headers) {
                    httpGet.addHeader(header);
                }
            }

            LOGGER.info("headers: \n{}", toJSONString(httpGet.getAllHeaders(), true));
            LOGGER.info("================================httpRequestInfo.end====================================================================");

            HttpResponse httpResponse = httpClient.execute(httpGet);

            // printObject(httpResponse, "httpResponse");

            // get the returnedContent
            HttpEntity httpEntity = httpResponse.getEntity();
            String returnedContent = httpEntity == null ? null : EntityUtils.toString(httpEntity);
            sleep(SLEEP_DURATION_BEFORE_PRINTING_RETURNED_CONTENT);
            LOGGER.info("=================returnedContent.head========================");
            LOGGER.info("{}", returnedContent);
            LOGGER.info("=================returnedContent.end========================");



            return returnedContent;

        } catch (Exception e) {

            LOGGER.info("e: [{}]", e);

            throw new RuntimeException(e);

        } finally {

            httpGet.releaseConnection();

        }

    }

    @SafeVarargs
    public static String httpGetKeyValuePairsWithCookiesAndHeaders(String httpApi,
                                                                   List<Cookie> cookies,
                                                                   List<Header> headers,
                                                                   Map.Entry<String, String>... keyValuePairs) {

        return httpGetKeyValuePairsWithCookiesAndHeaders(httpApi, cookies, headers, true, keyValuePairs);

    }

    @SafeVarargs
    public static String httpGetKeyValuePairs(String httpApi,
                                              Map.Entry<String, String>... keyValuePairs) {

        return httpGetKeyValuePairsWithCookiesAndHeaders(httpApi, null, null, keyValuePairs);

    }

    @SafeVarargs
    private static String populateUrlWithValuesEncoded(String httpApi, Map.Entry<String, String>... keyValuePairs) throws UnsupportedEncodingException {

        StringBuilder url = new StringBuilder();

        url.append(httpApi);
        url.append("?");
        if(keyValuePairs!=null) {
            for (Map.Entry<String, String> entry : keyValuePairs) {
                url.append(entry.getKey());
                url.append("=");
                url.append(URLEncoder.encode(entry.getValue(), "utf-8"));
                url.append("&");
            }
        }

        // delete the trailing "&" if there're keyValuePairs or the trailing "?" if there aren't any keyValuePairs.
        url.deleteCharAt(url.length() - 1);

        LOGGER.info("populatedUrlWithValuesEncoded: \n{}", url.toString());

        return url.toString();

    }

    @SuppressWarnings("unused")
    private static void ___________________________________________POST___________________________________________() {
    }

    @SuppressWarnings("unused")
    private static void ____________________postKeyValuePairsSeries____________________() {
    }

    @SafeVarargs
    public static String httpPostKeyValuePairsWithCookiesAndHeaders(String httpApi,
                                                                    List<Cookie> cookies,
                                                                    List<Header> headers,
                                                                    boolean checkReturnCode,
                                                                    Map.Entry<String, String>... keyValuePairs) {

        LOGGER.info("================================httpRequestInfo.head====================================================================");
        LOGGER.info("httpPostKeyValuePairsWithCookiesAndHeaders:");
        LOGGER.info("httpApi: \n{}", httpApi);
        LOGGER.info("keyValuePairs: \n{}", toJSONString(keyValuePairs, true));
        LOGGER.info("cookies: \n{}", toJSONString(cookies, true));

        HttpClient httpClient;
        HttpPost httpPost = null;

        try {

            if (cookies == null) {

                httpClient = HttpClients.createDefault();

            } else {

                //@formatter:off
                BasicCookieStore cookieStore = new BasicCookieStore() {{
                    addCookies(cookies.toArray(new Cookie[0]));
                }};
                //@formatter:on

                httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

            }

            httpPost = new HttpPost(httpApi);

            if (headers != null) {
                for (Header header : headers) {
                    httpPost.addHeader(header);
                }
            }

            LOGGER.info("headers: \n{}", toJSONString(httpPost.getAllHeaders(), true));
            LOGGER.info("================================httpRequestInfo.end====================================================================");

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

            for (Map.Entry<String, String> entry : keyValuePairs) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            // printObject(httpResponse, "httpResponse");

            // get the returnedContent
            HttpEntity httpEntity = httpResponse.getEntity();
            String returnedContent = httpEntity == null ? null : EntityUtils.toString(httpEntity);
            sleep(SLEEP_DURATION_BEFORE_PRINTING_RETURNED_CONTENT);
            LOGGER.info("=================returnedContent.head========================");
            LOGGER.info("{}", returnedContent);
            LOGGER.info("=================returnedContent.end========================");



            return returnedContent;

        } catch (Exception e) {

            LOGGER.info("e: [{}]", e);

            throw new RuntimeException(e);

        } finally {

            httpPost.releaseConnection();

        }

    }

    @SafeVarargs
    public static String httpPostKeyValuePairsWithCookiesAndHeaders(String httpApi,
                                                                    List<Cookie> cookies,
                                                                    List<Header> headers,
                                                                    Map.Entry<String, String>... keyValuePairs) {

        return httpPostKeyValuePairsWithCookiesAndHeaders(httpApi, cookies, headers, true, keyValuePairs);

    }

    @SafeVarargs
    public static String httpPostKeyValuePairs(String httpApi,
                                               Map.Entry<String, String>... keyValuePairs) {

        return httpPostKeyValuePairsWithCookiesAndHeaders(httpApi, null, null, keyValuePairs);

    }

    @SafeVarargs
    public static String httpPostKeyValuePairsWithToken(String httpApi,
                                                        Map.Entry<String, String>... keyValuePairs) {

        return httpPostKeyValuePairsWithCookiesAndHeaders(httpApi, null, createList(auth_token), keyValuePairs);

    }

    @SafeVarargs
    public static Cookie[] httpPostKeyValuePairsWithCookiesAndHeadersToGetSetCookiesHeaders(String httpApi,
                                                                                            boolean checkReturnCode,
                                                                                            String cookieToGet,
                                                                                            Map.Entry<String, String>... keyValuePairs) {

        LOGGER.info("================================httpRequestInfo.head====================================================================");
        LOGGER.info("httpPostKeyValuePairsWithCookiesAndHeaders:");
        LOGGER.info("httpApi: \n{}", httpApi);
        LOGGER.info("keyValuePairs: \n{}", toJSONString(keyValuePairs, true));

        HttpClient httpClient;
        HttpPost httpPost = null;

        try {
            BasicCookieStore cookieStore = new BasicCookieStore();

            httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

            httpPost = new HttpPost(httpApi);

            LOGGER.info("================================httpRequestInfo.end====================================================================");

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

            for (Map.Entry<String, String> entry : keyValuePairs) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

            HttpResponse httpResponse = httpClient.execute(httpPost);

            // get the returnedContent
            HttpEntity httpEntity = httpResponse.getEntity();
            String returnedContent = httpEntity == null ? null : EntityUtils.toString(httpEntity);
            sleep(SLEEP_DURATION_BEFORE_PRINTING_RETURNED_CONTENT);
            LOGGER.info("=================returnedContent.head========================");
            LOGGER.info("{}", returnedContent);
            LOGGER.info("=================returnedContent.end========================");

            Header[] setCookiesHeaders = httpResponse.getHeaders("Set-Cookie");

            List<Cookie> setCookies = cookieStore.getCookies();

            return setCookies.toArray(new Cookie[0]);

        } catch (Exception e) {

            LOGGER.info("e: [{}]", e);

            throw new RuntimeException(e);

        } finally {
            if(httpPost!=null)
                httpPost.releaseConnection();

        }

    }

    @SuppressWarnings("unused")
    private static void ____________________postJsonSeries____________________() {
    }

    @SafeVarargs
    public static String httpPostJsonAndKeyValuePairsWithCookiesAndHeaders(String httpApi,
                                                                           String jsonString,
                                                                           List<Cookie> cookies,
                                                                           List<Header> headers,
                                                                           boolean checkReturnCode,
                                                                           Map.Entry<String, String>... keyValuePairs) {

        LOGGER.info("================================httpRequestInfo.head====================================================================");
        LOGGER.info("httpPostJsonAndKeyValuePairsWithCookiesAndHeaders:");
        LOGGER.info("httpApi: \n{}", httpApi);
        LOGGER.info("jsonString: \n{}", jsonString);
        LOGGER.info("keyValuePairs: \n{}", toJSONString(keyValuePairs, true));
        LOGGER.info("cookies: \n{}", toJSONString(cookies, true));

        HttpClient httpClient;
        HttpPost httpPost = null;

        try {

            if (cookies == null) {

                httpClient = HttpClients.createDefault();

            } else {

                //@formatter:off
                BasicCookieStore cookieStore = new BasicCookieStore() {{
                    addCookies(cookies.toArray(new Cookie[0]));
                }};
                //@formatter:on

                httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

            }

            httpPost = new HttpPost(populateUrlWithValuesEncoded(httpApi, keyValuePairs));

            if (headers != null) {
                for (Header header : headers) {
                    httpPost.addHeader(header);
                }
            }

            httpPost.addHeader("content-type", "application/json");
            LOGGER.info("headers: \n{}", toJSONString(httpPost.getAllHeaders(), true));
            LOGGER.info("================================httpRequestInfo.end====================================================================");
            httpPost.setEntity(new StringEntity(jsonString, "UTF-8"));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            // printObject(httpResponse, "httpResponse");

            // get the returnedContent
            HttpEntity httpEntity = httpResponse.getEntity();
            String returnedContent = httpEntity == null ? null : EntityUtils.toString(httpEntity);
            sleep(SLEEP_DURATION_BEFORE_PRINTING_RETURNED_CONTENT);
            LOGGER.info("=================returnedContent.head========================");
            LOGGER.info("{}", returnedContent);
            LOGGER.info("=================returnedContent.end========================");

            return returnedContent;

        } catch (Exception e) {

            LOGGER.info("e: [{}]", e);

            throw new RuntimeException(e);

        } finally {

            if(httpPost!=null)
                httpPost.releaseConnection();

        }
    }

    @SafeVarargs
    public static String httpPostJsonAndKeyValuePairsWithCookiesAndHeaders(String httpApi,
                                                                           String jsonString,
                                                                           List<Cookie> cookies,
                                                                           List<Header> headers,
                                                                           Map.Entry<String, String>... keyValuePairs) {

        return httpPostJsonAndKeyValuePairsWithCookiesAndHeaders(httpApi, jsonString, cookies, headers, true, keyValuePairs);

    }

    @SafeVarargs
    public static String httpPostJsonAndKeyValuePairs(String httpApi,
                                                      String jsonString,
                                                      Map.Entry<String, String>... keyValuePairs) {

        return httpPostJsonAndKeyValuePairsWithCookiesAndHeaders(httpApi, jsonString, null, null, keyValuePairs);

    }

    public static String httpPostJsonWithCookiesAndHeaders(String httpApi,
                                                           String jsonString,
                                                           List<Cookie> cookies,
                                                           List<Header> headers) {

        return httpPostJsonAndKeyValuePairsWithCookiesAndHeaders(httpApi, jsonString, cookies, headers);

    }

    public static String httpPostJson(String httpApi,
                                      String jsonString) {

        return httpPostJsonWithCookiesAndHeaders(httpApi, jsonString, null, null);

    }

    public static String httpPostJsonWithToken(String httpApi,
                                               String jsonString) {

        return httpPostJsonWithCookiesAndHeaders(httpApi, jsonString, null, createList(auth_token));

    }

    @SuppressWarnings("unused")
    private static void ____________________deleteKeyValuePairsSeries____________________() {
    }

    @SafeVarargs
    public static String httpDeleteKeyValuePairsWithCookiesAndHeaders(String httpApi,
                                                                      List<Cookie> cookies,
                                                                      List<Header> headers,
                                                                      boolean checkReturnCode,
                                                                      Map.Entry<String, String>... keyValuePairs) {

        LOGGER.info("================================httpRequestInfo.head====================================================================");
        LOGGER.info("httpDeleteKeyValuePairsWithCookiesAndHeaders:");
        LOGGER.info("httpApi: \n{}", httpApi);
        LOGGER.info("keyValuePairs: \n{}", toJSONString(keyValuePairs, true));
        LOGGER.info("cookies: \n{}", toJSONString(cookies, true));

        HttpClient httpClient;
        HttpDelete httpDelete = null;

        try {

            if (cookies == null) {

                httpClient = HttpClients.createDefault();

            } else {

                //@formatter:off
                BasicCookieStore cookieStore = new BasicCookieStore() {{
                    addCookies(cookies.toArray(new Cookie[0]));
                }};
                //@formatter:on

                httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

            }

            httpDelete = new HttpDelete(populateUrlWithValuesEncoded(httpApi, keyValuePairs));

            if (headers != null) {
                for (Header header : headers) {
                    httpDelete.addHeader(header);
                }
            }

            httpDelete.addHeader("content-type", "application/json");
            LOGGER.info("headers: \n{}", toJSONString(httpDelete.getAllHeaders(), true));
            LOGGER.info("================================httpRequestInfo.end====================================================================");

            HttpResponse httpResponse = httpClient.execute(httpDelete);
            // printObject(httpResponse, "httpResponse");

            // get the returnedContent
            HttpEntity httpEntity = httpResponse.getEntity();
            String returnedContent = httpEntity == null ? null : EntityUtils.toString(httpEntity);
            sleep(SLEEP_DURATION_BEFORE_PRINTING_RETURNED_CONTENT);
            LOGGER.info("=================returnedContent.head========================");
            LOGGER.info("{}", returnedContent);
            LOGGER.info("=================returnedContent.end========================");


            return returnedContent;

        } catch (Exception e) {

            LOGGER.info("e: [{}]", e);

            throw new RuntimeException(e);

        } finally {

            if(httpDelete!=null)
                httpDelete.releaseConnection();

        }
    }

    @SuppressWarnings("unused")
    private static void ___________________________________________misc___________________________________________() {
    }

    public static Map.Entry<String, String> pair(String key, String value) {
        return new AbstractMap.SimpleEntry<String, String>(key, value);
    }

    /**
     * @formatter:off ============================================================
     * cookie example:
     * <p>
     * new BasicClientCookie(cookieName, cookieValue) {{
     * setDomain(cookieDomain);
     * setPath(cookiePath);
     * }}
     * <p>
     * Note:
     * <p>
     * cookieDomain:
     * For [something.foo.com] it's [something.foo.com];
     * For [1.2.3.4:8080] it's [1.2.3.4];
     * <p>
     * cookiePath example:
     * "/"
     * <p>
     * ============================================================
     * header example:
     * <p>
     * new BasicHeader(headerName, headerValue)
     * ============================================================
     * @formatter:on
     */
    public static void template() {

        //@formatter:off
        httpGetKeyValuePairsWithCookiesAndHeaders("http://pike.foo.com:8080/testAssistance/printHeaders",
                createList(
                        new BasicClientCookie("cookieName1", "cookieValue1") {{
                            setDomain("pike.foo.com");
                            setPath("/");
                        }},
                        new BasicClientCookie("cookieName2", "cookieValue2") {{
                            setDomain("pike.foo.com");
                            setPath("/");
                        }}
                ),
                createList(
                        new BasicHeader("headerName1", "headerValue1"),
                        new BasicHeader("headerName2", "headerValue2")
                )
        );
        //@formatter:on

    }

    public static <E> List<E> createList(E... elements) {

        List<E> list = new ArrayList<>();

        for (E element : elements) {
            list.add(element);
        }

        return list;

    }
}
