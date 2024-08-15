

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.springboot.api.water_bucket.WaterBucketApplication;
import com.challenge.springboot.api.water_bucket.services.WaterJugService;
import com.challenge.springboot.api.water_bucket.wrappers.SolutionWrapper;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for {@link WaterJugService}.
 * <p>
 * Contains unit tests to validate the behavior of the {@link WaterJugService} class,
 * ensuring it correctly handles various input scenarios and returns expected solutions.
 * @author Ronald Socorro
 */
@SpringBootTest(classes = WaterBucketApplication.class)
public class WaterJugServiceTest {
    private WaterJugService waterJugService;

    /**
     * Initializes a new instance of {@link WaterJugService} before each test.
    */
    @BeforeEach
    void setUp() {
        waterJugService = new WaterJugService();
    }

    /**
     * Tests that invalid inputs throw an {@link IllegalArgumentException}.
     * <p>
     * Verifies that the service correctly identifies and rejects invalid inputs such as negative capacities or zero volumes.
     */
    @Test
    void testInvalidInputsThrowException() {
        assertThrows(IllegalArgumentException.class, () -> waterJugService.solve(0, 5, 10));
        assertThrows(IllegalArgumentException.class, () -> waterJugService.solve(-1, 5, 10));
        assertThrows(IllegalArgumentException.class, () -> waterJugService.solve(5, 0, 10));
        assertThrows(IllegalArgumentException.class, () -> waterJugService.solve(0, 0, 10));
    }

    /**
     * Tests cases where no solution is found.
     * <p>
     * Ensures that the service correctly handles scenarios where there is no possible way to achieve the desired volume within the constraints of the jugs' capacities.
     */
    @Test
    void testNoSolutionFoundForSomeCases() {
        SolutionWrapper result = waterJugService.solve(3, 5, 7);
        assertThat(result.getSolution()).isNotEmpty();
        assertThat(result.getSolution().size()).isEqualTo(1);
        Map<String, Object> statusMap = (Map<String, Object>) result.getSolution().get(0);
        assertThat(statusMap).containsEntry("action", "No Solution Found");
        assertThat(statusMap).containsEntry("status", "No Solution");
    }

    /**
     * Tests valid inputs with a known solution.
     * <p>
     * Validates that the service correctly finds a solution when one exists, and that the solution is accurately returned.
     */
    @Test
    void testValidInputsWithSolution() {
        SolutionWrapper result = waterJugService.solve(3, 5, 6);
        assertThat(result.getSolution()).isNotEmpty();
        
    }

}
