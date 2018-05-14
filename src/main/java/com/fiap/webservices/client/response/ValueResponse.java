package com.fiap.webservices.client.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class ValueResponse implements Serializable {

    private String text;
    private Double value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
