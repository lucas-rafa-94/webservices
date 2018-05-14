package com.fiap.webservices.client.response;

import java.io.Serializable;
import java.util.List;

public class RoutesResponse implements Serializable {

    private LegsResponse legs;

    public LegsResponse getLegs() {
        return legs;
    }

    public void setLegs(LegsResponse legs) {
        this.legs = legs;
    }
}
