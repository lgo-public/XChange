package org.knowm.xchange.lgo.dto.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LgoWithdrawalRequest {

  private final String amount;
  private final String address;
  private final String token;

  public LgoWithdrawalRequest(String address, String amount, String token) {
    this.amount = amount;
    this.address = address;
    this.token = token;
  }

  public String getAmount() {
    return amount;
  }

  public String getAddress() {
    return address;
  }

  public String getToken() {
    return token;
  }

}
