package com.fiap.webservices.client.response;

import java.io.Serializable;
import java.util.List;

public class LegsResponse implements Serializable {


    private ValueResponse distance;

    private ValueResponse duration;

    public ValueResponse getDistance() {
        return distance;
    }

    public void setDistance(ValueResponse distance) {
        this.distance = distance;
    }

    public ValueResponse getDuration() {
        return duration;
    }

    public void setDuration(ValueResponse duration) {
        this.duration = duration;
    }
}
