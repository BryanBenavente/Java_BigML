package dao;

import java.io.IOException;
import model.Dato;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApiD {

    public String getData() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet request = new HttpGet("https://bigml.io/andromeda/logisticregression/5f21bf95cb4f966410001f9a?username=bryanbenavente;api_key=6bdd6d1dbf8ac8a270e56896062c3083555bfcc8");
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            System.out.println(entity);
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                return result;
            }
        } catch (IOException i) {
            System.out.println(i);
        } finally {
            httpClient.close();
        }
        return null;
    }

    public String postPredict(Dato data) throws IOException {
        String result = "";
        HttpPost post = new HttpPost("https://bigml.io/andromeda/prediction?username=bryanbenavente;api_key=6bdd6d1dbf8ac8a270e56896062c3083555bfcc8");
        post.addHeader("content-type", "application/json");
        StringBuilder entity = new StringBuilder();
        entity.append("{");
        entity.append("\"model\":\"logisticregression/5f21bf95cb4f966410001f9a\",");
        entity.append("\"input_data\":{");
        entity.append("\"age\":" + data.getAge() + ",");
        entity.append("\"anaemia\":" + data.getAnaemia() + ",");
        entity.append("\"creatinine_phosphokinase\":" + data.getCpk() + ",");
        entity.append("\"diabetes\":" + data.getDiabetes() + ",");
        entity.append("\"ejection_fraction\":" + data.getEjection_fraction() + ",");
        entity.append("\"high_blood_pressure\":" + data.getHigh_blood_pressure() + ",");
        entity.append("\"platelets\":" + data.getPlatelets() + ",");
        entity.append("\"serum_creatinine\":" + data.getSerum_creatinine() + ",");
        entity.append("\"serum_sodium\":" + data.getSerum_sodium() + ",");
        entity.append("\"sex\":" + data.getSex() + ",");
        entity.append("\"smoking\":" + data.getSmoking());
        entity.append("}");
        entity.append("}");
        System.out.println(entity);
        // send a JSON data
        System.setProperty("javax.net.ssl.trustStore","clientTrustStore.key");
        System.setProperty("javax.net.ssl.trustStorePassword","qwerty");
        
        post.setEntity(new StringEntity(entity.toString()));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post)) {
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(result);
        return result;
    }

}
