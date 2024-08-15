import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.challenge.springboot.api.water_bucket.WaterBucketApplication;

/**
 * Test class for the WaterBucket application.
 * <p>
 * This class contains unit tests to verify the functionality of the application.
 * @author Ronald Socorro
 */
@SpringBootTest(classes = WaterBucketApplication.class)
@AutoConfigureMockMvc
public class WaterBucketApplicationTest {

    /**
     * Instance of MockMvc used to perform simulated HTTP requests.
     */
	@Autowired
    private MockMvc mockMvc;

    /**
     * Unit test for the solve method.
     * <p>
     * This test verifies that a POST request to "/api/waterjug" with a specific JSON body
     * {\"x_capacity\":2,\"y_capacity\":10,\"z_amount_wanted\":5}
     * results in an HTTP 400 (Bad Request) status.
     *
     * @throws Exception if an error occurs during test execution
     */
	@Test
    void testSolve() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/waterjug")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"x_capacity\":2,\"y_capacity\":10,\"z_amount_wanted\":5}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
