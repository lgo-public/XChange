package org.knowm.xchange.lgo;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.knowm.xchange.lgo.dto.LgoException;
import org.knowm.xchange.lgo.dto.account.LgoAccountDetails;
import org.knowm.xchange.lgo.dto.account.LgoWithdrawalRequest;
import org.knowm.xchange.lgo.dto.account.LgoWithdrawalResponse;
import si.mazi.rescu.ParamsDigest;

@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public interface LgoAccountApi {

  String X_LGO_DATE = "X-LGO-DATE";
  String AUTHORIZATION = "Authorization";

  @GET
  @Path("/me")
  LgoAccountDetails getAccountDetails(
      @HeaderParam(X_LGO_DATE) long timestamp,
      @HeaderParam(AUTHORIZATION) ParamsDigest signature)
      throws IOException, LgoException;


  @POST
  @Path("/withdrawals")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  LgoWithdrawalResponse withdrawFunds(
      LgoWithdrawalRequest withdrawalRequest,
      @HeaderParam(X_LGO_DATE) long timestamp,
      @HeaderParam(AUTHORIZATION) ParamsDigest signature)
      throws IOException, LgoException;
}
