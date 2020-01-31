package org.knowm.xchange.lgo;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.account.Fee;
import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.lgo.service.LgoAccountService;

public class LgoExchangeAccountIntegration {

  @Test
  public void fetchFees() throws IOException {
    LgoExchange lgoExchange = exchangeWithCredentials();

    Map<CurrencyPair, Fee> fees = lgoExchange.getAccountService().getDynamicTradingFees();

    assertThat(fees).isNotNull().containsKeys(CurrencyPair.BTC_USD);
  }

  @Test
  public void requestWithdrawal() throws IOException {
    LgoExchange lgoExchange = exchangeWithCredentials();

    String id =
        lgoExchange
            .getAccountService()
            .withdrawFunds(Currency.BTC, new BigDecimal(3), "nrstnrstnr");

    assertThat(id).isNotNull();
    System.out.println(id);
  }

  @Test
  public void getOperation() throws IOException {
    LgoExchange lgoExchange = exchangeWithCredentials();

    FundingRecord result = ((LgoAccountService) lgoExchange.getAccountService())
        .getOperation("ae21f25b-dcdd-4bac-b475-1d45c64e17a8");

    System.out.println(result);
  }

  private LgoExchange exchangeWithCredentials() throws IOException {
    ExchangeSpecification spec = LgoEnv.local();
    spec.setShouldLoadRemoteMetaData(false);
    spec.setSecretKey(readResource("/integration/private_key.pem"));
    spec.setApiKey(readResource("/integration/api_key.txt"));

    return (LgoExchange) ExchangeFactory.INSTANCE.createExchange(spec);
  }

  private String readResource(String path) throws IOException {
    InputStream stream = LgoExchange.class.getResourceAsStream(path);
    return IOUtils.toString(stream, StandardCharsets.UTF_8);
  }
}
