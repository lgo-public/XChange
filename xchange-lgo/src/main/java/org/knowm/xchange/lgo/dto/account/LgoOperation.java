package org.knowm.xchange.lgo.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class LgoOperation {

  public LgoOperation(
      @JsonProperty("id") UUID id,
      @JsonProperty("account_id") UUID accountId,
      @JsonProperty("owner_id") long ownerId,
      @JsonProperty("type") String type,
      @JsonProperty("status") String status,
      @JsonProperty("quantity") String quantity,
      @JsonProperty("currency") String currency,
      @JsonProperty("counter_party") String counterParty,
      @JsonProperty("created_at") long createdAt,
      @JsonProperty("protocol") String protocol) {
    this.id = id;
    this.accountId = accountId;
    this.ownerId = ownerId;
    this.type = type;
    this.status = status;
    this.quantity = quantity;
    this.currency = currency;
    this.counterParty = counterParty;
    this.createdAt = createdAt;
    this.protocol = protocol;
  }

  public UUID getId() {
    return id;
  }

  public UUID getAccountId() {
    return accountId;
  }

  public long getOwnerId() {
    return ownerId;
  }

  public String getType() {
    return type;
  }

  public String getStatus() {
    return status;
  }

  public String getQuantity() {
    return quantity;
  }

  public String getCurrency() {
    return currency;
  }

  public String getCounterParty() {
    return counterParty;
  }

  public long getCreatedAt() {
    return createdAt;
  }

  public String getProtocol() {
    return protocol;
  }

  private UUID id;
  private UUID accountId;
  private long ownerId;
  private String type;
  private String status;
  private String quantity;
  private String currency;
  private String counterParty;
  private long createdAt;
  private String protocol;
}
