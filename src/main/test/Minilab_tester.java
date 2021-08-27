import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import se.nackademin.java20.lab1.models.Account;
import se.nackademin.java20.lab1.models.User;
import se.nackademin.java20.lab1.presentation.AccountDeserialized;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Minilab_tester {
    //Dessa är tester gjorda för minilab

    private final String json = "{\"balance\":0,\"holder\":\"Kalle\"}";
    private User user = new User("Lili", 12);
    private Account account = new Account(user, 0);

    @Test
    public void deserialize() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        AccountDeserialized accountDeserialized = objectMapper.readValue(json, AccountDeserialized.class);

        assertEquals(accountDeserialized.getBalance(), 0);
        assertEquals(accountDeserialized.getHolder(), "Kalle");
    }

    @Test
    public void serialize() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        AccountDeserialized accountDeserialized = new AccountDeserialized(0, "Kalle");

        String jsonObject = objectMapper.writeValueAsString(accountDeserialized);
        System.out.println(jsonObject);

        assertEquals(json, jsonObject);

    }

    @Test
    public void rest(){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> forEntity = restTemplate.getForEntity("https://google.se", String.class);

        System.out.println(forEntity.getStatusCode());
        System.out.println(forEntity.getBody());
    }

    @Test
    public void testZeroBalanceWhenCreated(){
        assertEquals(account.getBalance(), 0);
    }

    @Test
    public void depositOneHundred(){
        account.deposit(100);
        assertEquals(account.getBalance(), 100);
    }

    @Test
    public void withdrawFifty(){
        account.deposit(100);
        account.withdraw(50);
        assertEquals(account.getBalance(), 50);
    }

    @Test
    public void withdrawTwoHundredAndThrowException(){
        account.deposit(100);
        assertThrows(IllegalStateException.class, () -> account.withdraw(200));
    }
}
