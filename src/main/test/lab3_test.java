import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.nackademin.java20.lab1.presentation.AccountDeserialized;
import se.nackademin.java20.lab1.presentation.RiskAssessmentDto;

import static org.junit.Assert.assertEquals;

public class lab3_test {
    RestTemplate restTemplate = new RestTemplate();
    @Test
    public void rest(){

        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8082/risk/dan", String.class);

        System.out.println(forEntity.getStatusCode());
        System.out.println(forEntity.getBody());
    }

    @Test
    public void deserialize(){
        ResponseEntity<RiskAssessmentDto> forEntity = restTemplate.getForEntity("http://localhost:8082/risk/dan", RiskAssessmentDto.class);

        RiskAssessmentDto risk = forEntity.getBody();
        assertEquals(RiskAssessmentDto.class, risk.getClass());
    }


}
