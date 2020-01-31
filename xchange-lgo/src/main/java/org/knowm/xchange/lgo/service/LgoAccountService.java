package org.knowm.xchange.lgo.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.account.Fee;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.lgo.LgoAdapters;
import org.knowm.xchange.lgo.LgoExchange;
import org.knowm.xchange.lgo.dto.account.LgoFeeRates;
import org.knowm.xchange.lgo.dto.account.LgoOperation;
import org.knowm.xchange.lgo.dto.account.LgoWithdrawalRequest;
import org.knowm.xchange.lgo.dto.account.LgoWithdrawalResponse;
import org.knowm.xchange.service.account.AccountService;

public class LgoAccountService extends LgoAccountServiceRaw implements AccountService {

  public LgoAccountService(LgoExchange exchange) {
    super(exchange);
  }

  @Override
  public Map<CurrencyPair, Fee> getDynamicTradingFees() throws IOException {
    LgoFeeRates rates = getDynamicTradingFeesLgo();
    Map<CurrencyPair, Fee> result = new HashMap<>();
    result.put(
        CurrencyPair.BTC_USD,
        new Fee(new BigDecimal(rates.getMakerRate()), new BigDecimal(rates.getTakerRate())));
    return result;
  }

  @Override
  public String withdrawFunds(Currency currency, BigDecimal amount, String address)
      throws IOException {
    LgoWithdrawalRequest request = new LgoWithdrawalRequest(address, amount.toPlainString(),
        currency.getCurrencyCode());
    LgoWithdrawalResponse result = this.requestWithdrawal(request);
    return result.getId().toString();
  }

  public FundingRecord getOperation(String id) throws IOException {
    LgoOperation lgoOperation = getLgoOperation(id);
    return LgoAdapters.adaptOperation(lgoOperation);
  }
}
