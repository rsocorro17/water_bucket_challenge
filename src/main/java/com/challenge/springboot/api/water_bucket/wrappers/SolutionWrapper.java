package com.challenge.springboot.api.water_bucket.wrappers;

import java.util.List;
import java.util.Map;

/**
 * Wrapper class for solutions to the water jug problem.
 * Encapsulates the steps taken to reach a solution, allowing for easy serialization
 * and deserialization of the solution data structure.
 *
 * @author Ronald Socorro
 */

public class SolutionWrapper {
    /**
     * The list of steps taken to reach the solution, where each step is represented
     * as a map containing information such as the action performed, the state of the buckets after the action,
     * and the step number.
    */
    private List<Map<String, Object>> solution;

    /**
     * Constructs a new {@code SolutionWrapper} with the given solution steps.
     *
     * @param solution The list of steps taken to reach the solution.
     */
    public SolutionWrapper(List<Map<String, Object>> solution) {
        this.solution = solution;
    }
    /**
     * Retrieves the list of solution steps.
     *
     * @return The list of solution steps.
    */
    public List<Map<String, Object>> getSolution() {
        return solution;
    }
    /**
     * Sets the list of solution steps.
     *
     * @param solution The list of solution steps to set.
    */
    public void setSolution(List<Map<String, Object>> solution) {
        this.solution = solution;
    }
}
