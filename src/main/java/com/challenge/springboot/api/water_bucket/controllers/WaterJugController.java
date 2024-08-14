package com.challenge.springboot.api.water_bucket.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.springboot.api.water_bucket.models.WaterJugRequest;
import com.challenge.springboot.api.water_bucket.services.WaterJugService;
import com.challenge.springboot.api.water_bucket.wrappers.SolutionWrapper;

/**
 * Controller class for handling HTTP requests related to the water jug problem.
 * It provides an endpoint for submitting a request to solve the problem
 * and returns the solution along with the steps taken to reach it.
 *
 * @author Ronald Socorro
 */
@RestController
@RequestMapping("/api/waterjug")
public class WaterJugController {

    /**
     * Autowired service for solving the water jug problem.
     */
    @Autowired
    private WaterJugService waterJugService;

    /**
     * Processes a POST request to solve the water jug problem based on the provided capacities
     * and target volume. Returns the solution and the steps taken to reach it.
     *
     * @param request An instance of {@link WaterJugRequest} containing the capacities of the jugs
     *                and the target volume.
     * @return A {@link ResponseEntity} containing either the solution wrapped in a JSON object
     *         or an error message indicating invalid input, along with an HTTP status code.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> solve(@RequestBody WaterJugRequest request) {
        System.out.println("Received request: " + request);
        int xCapacity = request.getXCapacity();
        int yCapacity = request.getYCapacity();
        int zAmountWanted = request.getZAmountWanted();

        if (xCapacity <= 0 || yCapacity <= 0 || zAmountWanted <= 0) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "The capacity should be positive numbers");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        SolutionWrapper solutionWrapper = waterJugService.solve(xCapacity, yCapacity, zAmountWanted);

        // Build the desired response
        Map<String, Object> response = new HashMap<>();
        response.put("solution", solutionWrapper.getSolution());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
