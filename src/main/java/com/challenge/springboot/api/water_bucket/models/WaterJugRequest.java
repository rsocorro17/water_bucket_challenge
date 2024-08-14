package com.challenge.springboot.api.water_bucket.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Model class representing a request to solve the water jug problem.
 * Contains the capacities of two jugs and the target volume to reach.
 * Used to encapsulate the input parameters required to solve the problem.
 *
 * @author Ronald Socorro
 */
@Setter
@Getter
public class WaterJugRequest {
    /**
     * Capacity of the first jug (in liters).
    */
    public int xCapacity;
    /**
     * Capacity of the second jug (in liters).
    */
    public int yCapacity;
    /**
     * Target volume to reach (in liters).
    */
    public int zAmountWanted;
}
