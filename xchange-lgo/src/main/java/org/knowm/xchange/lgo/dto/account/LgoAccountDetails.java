package org.knowm.xchange.lgo.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LgoAccountDetails {

  private final String origin;
  private final LgoFeeRates rates;

  public LgoAccountDetails(
      @JsonProperty("origin") String origin, @JsonProperty("rates") LgoFeeRates rates) {
    this.origin = origin;
    this.rates = rates;
  }

  public String getOrigin() {
    return origin;
  }

  public LgoFeeRates getRates() {
    return rates;
  }
}
