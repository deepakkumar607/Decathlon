package decathlon.decathlonadminproject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAPIService {

    public void callExternalAPI(ChangeRequest changeRequest) {
        String apiUrl = "https://api.example.com/update"; // Replace with the actual API URL

        RestTemplate restTemplate = new RestTemplate();

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create request body
        String requestBody = "{\"email\":\"" + changeRequest.getNewEmail() + "\",\"phone\":\"" + changeRequest.getNewPhone() + "\"}";

        // Create HttpEntity with headers and request body
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Send POST request
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class);

        // Handle the response as needed
        if (response.getStatusCode().is2xxSuccessful()) {
            // API call successful
            System.out.println("API call successful");
        } else {
            // API call failed
            System.out.println("API call failed");
        }
    }
}
