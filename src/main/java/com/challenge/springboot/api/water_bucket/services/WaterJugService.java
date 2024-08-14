package com.challenge.springboot.api.water_bucket.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.challenge.springboot.api.water_bucket.wrappers.SolutionWrapper;

/**
 * Service class responsible for solving the water jug problem.
 * This problem involves transferring water between two jugs with given capacities
 * to reach a target volume using a minimum number of operations.
 *
 * @author Ronald Socorro
 */
@Service
public class WaterJugService {
    /**
     * Solves the water jug problem by filling and transferring water between two jugs
     * until reaching the target volume or determining that it's not possible.
     *
     * @param x Capacity of the first jug (in liters).
     * @param y Capacity of the second jug (in liters).
     * @param z Target volume to reach (in liters).
     * @return A {@link SolutionWrapper} object detailing the steps taken to reach the solution.
     * @throws IllegalArgumentException if any of the capacities (x, y, z) are less than or equal to zero.
     */
    public SolutionWrapper solve(int x, int y, int z) {
        if (x <= 0 || y <= 0 || z <= 0) {
            throw new IllegalArgumentException("The capacities should be positive numbers");
        }

        List<Map<String, Object>> steps = new ArrayList<>();
        int stepNumber = 1;

        // Initial Step: Fill X Bucket
        steps.add(Map.of("step", stepNumber++, "bucketX", x, "bucketY", 0, "action", "Fill bucket X"));

        // Step 2: Transfer water of bucket X to Y
        steps.add(Map.of("step", stepNumber++, "bucketX", 0, "bucketY", x, "action", "Transfer from bucket X to Y"));

        // Step 3: Calculate how quantity needs to fill bucket Y or complete the transfer
        steps.add(Map.of("step", stepNumber++, "bucketX", x, "bucketY", Math.min(y, x), "action", "Fill bucket X"));

        // Verify if objective Z fill Y bucket
        if (y >= z) {
            steps.add(Map.of("step", stepNumber++, "bucketX", 0, "bucketY", z, "action", "Solution Found", "status", "Solved"));
            return new SolutionWrapper(steps);
        }

        // if Z is incomplete, drop X bucket and repeat the process.
        while (y < z && x > 0) {
            steps.add(Map.of("step", stepNumber++, "bucketX", x, "bucketY", 0, "action", "Empty bucket X"));
            steps.add(Map.of("step", stepNumber++, "bucketX", x, "bucketY", Math.min(y, x), "action", "Fill bucket X"));
            steps.add(Map.of("step", stepNumber++, "bucketX", 0, "bucketY", x, "action", "Transfer from bucket X to Y"));
            x -= 1; // Drop the X bucket complete
            y += 1; // Agregate 1 to de Y bucket
        }

        // Final step: Verify if Z is completed
        if (y >= z) {
            steps.add(Map.of("step", stepNumber++, "bucketX", 0, "bucketY", z, "action", "Solution Found", "status", "Solved"));
        } else {
            steps.add(Map.of("step", stepNumber++, "bucketX", x, "bucketY", y, "action", "No solution found", "status", "Not Solved"));
        }

        return new SolutionWrapper(steps);
    }
}
