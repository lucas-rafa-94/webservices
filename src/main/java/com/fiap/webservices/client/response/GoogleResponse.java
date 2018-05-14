package com.fiap.webservices.client.response;

import java.io.Serializable;
import java.util.List;

public class GoogleResponse implements Serializable {

    private RoutesResponse routes;

    public RoutesResponse getRoutes() {
        return routes;
    }

    public void setRoutes(RoutesResponse routes) {
        this.routes = routes;
    }
}
