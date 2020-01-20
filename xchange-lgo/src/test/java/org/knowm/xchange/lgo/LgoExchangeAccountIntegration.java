package org.knowm.xchange.lgo;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.account.Fee;

@Ignore
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

  private LgoExchange exchangeWithCredentials() throws IOException {
    ExchangeSpecification spec = LgoEnv.local();
    spec.setSecretKey(readResource("/integration/private_key.pem"));
    spec.setApiKey(readResource("/integration/api_key.txt"));

    return (LgoExchange) ExchangeFactory.INSTANCE.createExchange(spec);
  }

  private String readResource(String path) throws IOException {
    InputStream stream = LgoExchange.class.getResourceAsStream(path);
    return IOUtils.toString(stream, StandardCharsets.UTF_8);
  }
}
