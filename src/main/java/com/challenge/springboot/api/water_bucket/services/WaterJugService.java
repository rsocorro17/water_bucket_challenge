package com.challenge.springboot.api.water_bucket.services;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
     * Solves the water jug problem using Breadth-First Search (BFS) algorithm.
     * The problem involves finding the minimum steps required to measure exactly Z gallons
     * using two jugs of capacities X and Y gallons. This method efficiently processes this problem
     * and returns the solution steps in a structured format.
     *
     * @param x Capacity of the first jug (in liters).
     * @param y Capacity of the second jug (in liters).
     * @param z Target volume to reach (in liters).
     * @return A {@link SolutionWrapper} object detailing the steps taken to reach the solution,
     * or indicating that no solution is possible.
     * @throws IllegalArgumentException if any of the capacities (x, y, z) are less than or equal to zero.
     */
    public SolutionWrapper solve(int x, int y, int z) {
        if (x <= 0 || y <= 0 || z <= 0) {
            throw new IllegalArgumentException("The capacities should be positive numbers");
        }

        int mcm = lcm(x, y);
        if (!(z % mcm == 0 || (z & 1) == 0)) {
            return new SolutionWrapper(List.of(Map.of("action", "No Solution Found", "status", "No Solution")));
        }

        List<Map<String, Object>> steps = new ArrayList<>();
        boolean[][] visited = new boolean[x + 1][y + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;   

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int bucketX = current[0];
            int bucketY = current[1];

            if (bucketY == z) {
                steps.add(Map.of("step", steps.size() + 1, "bucketX", bucketX, "bucketY", bucketY, "action", "Solved", "status", "Solved"));
                return new SolutionWrapper(steps);
            }
                
            tryAllActions(bucketX, bucketY, x, y, z, visited, queue, steps);
        }
        
        return new SolutionWrapper(List.of(Map.of("action", "No Solution Found", "status", "No Solution")));
    }             

    /**
     * Tries all possible actions (filling, emptying, and transferring water) from the current state.
     * Adds the resulting states to the queue and marks them as visited to avoid processing the same state again.
     *
     * @param bucketX Current level of the first bucket.
     * @param bucketY Current level of the second bucket.
     * @param x Capacity of the first bucket.
     * @param y Capacity of the second bucket.
     * @param z Target volume to reach.
     * @param visited Matrix to track visited states.
     * @param queue Queue for BFS.
     * @param steps List to store the steps taken to reach the solution.
     */
    private void tryAllActions(int bucketX, int bucketY, int x, int y, int z, boolean[][] visited, Queue<int[]> queue,
        List<Map<String, Object>> steps) {
            
            if (bucketX < x && !visited[x][bucketY]) {
                queue.offer(new int[]{x, bucketY});
                visited[x][bucketY] = true;
                steps.add(Map.of("step", steps.size() + 1, "bucketX", x, "bucketY", bucketY, "action", "Fill bucket X"));
            }

            if (bucketY < y && !visited[bucketX][y]) {
                queue.offer(new int[]{bucketX, y});
                visited[bucketX][y] = true;
                steps.add(Map.of("step", steps.size() + 1, "bucketX", bucketX, "bucketY", y, "action", "Fill bucket Y"));
            }

            if (bucketX > 0 && !visited[0][bucketY]) {
                queue.offer(new int[]{0, bucketY});
                visited[0][bucketY] = true;
                steps.add(Map.of("step", steps.size() + 1, "bucketX", 0, "bucketY", bucketY, "action", "Empty bucket X"));
            }

            if (bucketY > 0 && !visited[bucketX][0]) {
                queue.offer(new int[]{bucketX, 0});
                visited[bucketX][0] = true;
                steps.add(Map.of("step", steps.size() + 1, "bucketX", bucketX, "bucketY", 0, "action", "Empty bucket Y"));
            }

            int transferAmount = Math.min(bucketX, y - bucketY);
            if (transferAmount > 0 && !visited[bucketX - transferAmount][bucketY + transferAmount]) {
                queue.offer(new int[]{bucketX - transferAmount, bucketY + transferAmount});
                visited[bucketX - transferAmount][bucketY + transferAmount] = true;
                steps.add(Map.of("step", steps.size() + 1, "bucketX", bucketX - transferAmount, "bucketY", bucketY + transferAmount, "action", "Transfer from bucket X to Y"));
            }

            transferAmount = Math.min(bucketY, x - bucketX);
            if (transferAmount > 0 && !visited[bucketX + transferAmount][bucketY - transferAmount]) {
                queue.offer(new int[]{bucketX + transferAmount, bucketY - transferAmount});
                visited[bucketX + transferAmount][bucketY - transferAmount] = true;
                steps.add(Map.of("step", steps.size() + 1, "bucketX", bucketX + transferAmount, "bucketY", bucketY - transferAmount, "action", "Transfer from bucket Y to X"));
            }
        }

    /**
     * Calculates the Greatest Common Divisor (GCD) of two integers.
     *
     * @param a First integer.
     * @param b Second integer.
     * @return GCD of the two integers.
     */
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    /**
     * Calculates the Least Common Multiple (LCM) of two integers.
     *
     * @param a First integer.
     * @param b Second integer.
     * @return LCM of the two integers.
     */
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
