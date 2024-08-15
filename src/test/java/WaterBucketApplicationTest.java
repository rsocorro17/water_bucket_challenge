import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.challenge.springboot.api.water_bucket.WaterBucketApplication;

@SpringBootTest(classes = WaterBucketApplication.class)
@AutoConfigureMockMvc
public class WaterBucketApplicationTest {

	@Autowired
    private MockMvc mockMvc;

	@Test
    void testSolve() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/waterjug")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"x_capacity\":2,\"y_capacity\":10,\"z_amount_wanted\":5}"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
