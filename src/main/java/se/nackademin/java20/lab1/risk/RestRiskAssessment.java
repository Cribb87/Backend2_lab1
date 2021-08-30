package se.nackademin.java20.lab1.risk;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.nackademin.java20.lab1.repositories.Adapter;

public class RestRiskAssessment implements Adapter {

    private final RestTemplate restTemplate;
    private final String baseUrl;


    public RestRiskAssessment(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public boolean isPassing(String userId) {
        final ResponseEntity<RiskAssessmentDto> entity = restTemplate.getForEntity(baseUrl + "/risk/" + userId, RiskAssessmentDto.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody().isPass();
        }
        throw new RuntimeException("Could not fetch risk assessment");
    }
}