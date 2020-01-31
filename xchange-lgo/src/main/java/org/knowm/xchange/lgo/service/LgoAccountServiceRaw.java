package org.knowm.xchange.lgo.service;

import java.io.IOException;
import org.knowm.xchange.lgo.LgoExchange;
import org.knowm.xchange.lgo.dto.account.LgoFeeRates;
import org.knowm.xchange.lgo.dto.account.LgoOperation;
import org.knowm.xchange.lgo.dto.account.LgoWithdrawalRequest;
import org.knowm.xchange.lgo.dto.account.LgoWithdrawalResponse;

public class LgoAccountServiceRaw extends LgoBaseService {

  protected LgoAccountServiceRaw(LgoExchange exchange) {
    super(exchange);
  }

  protected LgoFeeRates getDynamicTradingFeesLgo() throws IOException {
    return this.accountApiProxy
        .getAccountDetails(exchange.getNonceFactory().createValue(), exchange.getSignatureService())
        .getRates();
  }

  protected LgoWithdrawalResponse requestWithdrawal(LgoWithdrawalRequest request)
      throws IOException {
    return this.accountApiProxy.withdrawFunds(
        request, exchange.getNonceFactory().createValue(), exchange.getSignatureService());
  }

  protected LgoOperation getLgoOperation(String operationId) throws IOException {
    return this.accountApiProxy.getOperation(
        exchange.getNonceFactory().createValue(), exchange.getSignatureService(), operationId);
  }
}
