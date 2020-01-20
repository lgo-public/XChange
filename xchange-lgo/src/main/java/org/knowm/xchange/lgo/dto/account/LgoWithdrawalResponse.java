package org.knowm.xchange.lgo.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class LgoWithdrawalResponse {

  private final UUID id;

  public LgoWithdrawalResponse(@JsonProperty("id") UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }
}
