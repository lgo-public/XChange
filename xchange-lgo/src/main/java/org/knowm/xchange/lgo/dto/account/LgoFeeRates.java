package org.knowm.xchange.lgo.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LgoFeeRates {

  private final String takerRate;
  private final String makerRate;
  private final boolean defaultRates;

  public LgoFeeRates(
      @JsonProperty("taker_rate") String takerRate,
      @JsonProperty("maker_rate") String makerRate,
      @JsonProperty("default_rates") boolean defaultRates) {
    this.takerRate = takerRate;
    this.makerRate = makerRate;
    this.defaultRates = defaultRates;
  }

  public String getTakerRate() {
    return takerRate;
  }

  public String getMakerRate() {
    return makerRate;
  }

  public boolean isDefaultRates() {
    return defaultRates;
  }
}
