package com.prebigdata.uma.master.bl;

import com.prebigdata.uma.master.common.HttpConstants;
import com.prebigdata.uma.master.domain.HttpRequestDTO;
import com.prebigdata.uma.master.domain.HttpResponseDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;

public class HttpBS {
    
    private static HttpResponseDTO HttprequestGET(HttpRequestDTO request) throws IOException {
        URL urlToCall = null;
        HttpResponseDTO httpResponse = null;
        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader = null;

        try {
            urlToCall = new URL(request.urlEndpoint);
            httpResponse = new HttpResponseDTO();
            urlConnection = (HttpURLConnection) urlToCall.openConnection();
            urlConnection.setRequestMethod(request.requestMethod);

            if (request.headers != null) {
                for (Entry<String, String> object : request.headers.entrySet()) {
                    urlConnection.setRequestProperty(object.getKey(), object.getValue());
                }
            }

            if (urlConnection.getResponseCode() == HttpConstants.HTTP_RESPONSE_CODE_200) {
                bufferedReader = new BufferedReader(
                                 new InputStreamReader(urlConnection.getInputStream(),
                                                       HttpConstants.UNICODE_TRANSFORMATION_FORMAT));

                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = bufferedReader.readLine()) != null) {

                    response.append(inputLine);
                }

                httpResponse.responseCode = urlConnection.getResponseCode();
                httpResponse.responseBody = response.toString();
                bufferedReader.close();
            }

            return httpResponse;
        } catch(IOException exception) {
            throw exception;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    private static HttpResponseDTO HttprequestPutPostDelete(HttpRequestDTO request) throws IOException {
        URL urlToCall = null;
        HttpResponseDTO httpResponse = null;
        HttpURLConnection urlConnection = null;
        OutputStream outputStringData = null;
        byte[] outputStringInBytes = null;

        try {
            urlToCall = new URL(request.urlEndpoint);
            httpResponse = new HttpResponseDTO();
            urlConnection = (HttpURLConnection) urlToCall.openConnection();
            urlConnection.setRequestMethod(request.requestMethod);

            if (request.headers != null) {
                for (Entry<String, String> object : request.headers.entrySet()) {
                    urlConnection.setRequestProperty(object.getKey(), object.getValue());
                }
            }

            outputStringInBytes = request.requestBody.getBytes(HttpConstants.UNICODE_TRANSFORMATION_FORMAT);
            urlConnection.setDoOutput(true);
            outputStringData = urlConnection.getOutputStream();
            outputStringData.write(outputStringInBytes);
            outputStringData.close();

            httpResponse.responseCode = urlConnection.getResponseCode();
            httpResponse.responseBody = urlConnection.getResponseMessage();

            return httpResponse;
        } catch(IOException exception) {
            throw exception;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    private static HttpResponseDTO HttpsrequestGET(HttpRequestDTO request) throws IOException {
        URL urlToCall = null;
        HttpResponseDTO httpResponse = null;
        HttpsURLConnection urlSecureConnection = null;
        BufferedReader bufferedReader = null;

        try {
            urlToCall = new URL(request.urlEndpoint);
            httpResponse = new HttpResponseDTO();
            urlSecureConnection = (HttpsURLConnection) urlToCall.openConnection();
            urlSecureConnection.setRequestMethod(request.requestMethod);

            if (request.headers != null) {
                for (Entry<String, String> object : request.headers.entrySet()) {
                    urlSecureConnection.setRequestProperty(object.getKey(), object.getValue());
                }
            }

            if (urlSecureConnection.getResponseCode() == HttpConstants.HTTP_RESPONSE_CODE_200) {
                bufferedReader = new BufferedReader(
                        new InputStreamReader(urlSecureConnection.getInputStream(),
                                HttpConstants.UNICODE_TRANSFORMATION_FORMAT));

                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = bufferedReader.readLine()) != null) {

                    response.append(inputLine);
                }

                httpResponse.responseCode = urlSecureConnection.getResponseCode();
                httpResponse.responseBody = response.toString();
                bufferedReader.close();
            }

            return httpResponse;
        } catch(IOException exception) {
            throw exception;
        } finally {
            if (urlSecureConnection != null) {
                urlSecureConnection.disconnect();
            }

            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }


    public static HttpResponseDTO request(HttpRequestDTO request) throws IOException {
        HttpResponseDTO response = null;

        try {
            if (request.requestMethod.equals(HttpConstants.GET_HTTP_METHOD)) {

                response = HttprequestGET(request);

            } else if ((request.requestMethod.equals(HttpConstants.PUT_HTTP_METHOD)
                        || request.requestMethod.equals(HttpConstants.POST_HTTP_METHOD)
                            || request.requestMethod .equals(HttpConstants.DELETE_HTTP_METHOD))) {

                response = HttprequestPutPostDelete(request);
            }

            return response;
        } catch (IOException exception) {
            throw exception;
        }
    }
}
