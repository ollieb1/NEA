package com.oblair.nea.application.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BondRequest {
    @NotBlank
    @Size(max = 30)
    private String isin;

}