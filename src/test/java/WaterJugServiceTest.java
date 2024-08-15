

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.springboot.api.water_bucket.WaterBucketApplication;
import com.challenge.springboot.api.water_bucket.services.WaterJugService;
import com.challenge.springboot.api.water_bucket.wrappers.SolutionWrapper;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = WaterBucketApplication.class)
public class WaterJugServiceTest {
    private WaterJugService waterJugService;

    @BeforeEach
    void setUp() {
        waterJugService = new WaterJugService();
    }

    @Test
    void testInvalidInputsThrowException() {
        assertThrows(IllegalArgumentException.class, () -> waterJugService.solve(0, 5, 10));
        assertThrows(IllegalArgumentException.class, () -> waterJugService.solve(-1, 5, 10));
        assertThrows(IllegalArgumentException.class, () -> waterJugService.solve(5, 0, 10));
        assertThrows(IllegalArgumentException.class, () -> waterJugService.solve(0, 0, 10));
    }

    @Test
    void testNoSolutionFoundForSomeCases() {
        SolutionWrapper result = waterJugService.solve(3, 5, 7);
        assertThat(result.getSolution()).isNotEmpty();
        assertThat(result.getSolution().size()).isEqualTo(1);
        Map<String, Object> statusMap = (Map<String, Object>) result.getSolution().get(0);
        assertThat(statusMap).containsEntry("action", "No Solution Found");
        assertThat(statusMap).containsEntry("status", "No Solution");
    }

    @Test
    void testValidInputsWithSolution() {
        SolutionWrapper result = waterJugService.solve(3, 5, 6);
        assertThat(result.getSolution()).isNotEmpty();
        
    }

}
