package com.assignment.question;

import com.assignment.question.external.AutoProtectStatus;
import com.assignment.question.external.TravelGuardApi;

public class TravelGuardAdapter implements TravelInsuranceAdapter {
  TravelGuardApi travelGuardApi = new TravelGuardApi();

  @Override
  public void submitClaim(String id, Double amount) {
    travelGuardApi.submitClaim(id, amount);
  }

  @Override
  public String getStatus(String id) {
    return travelGuardApi.getClaimStatus(id);
  }
}
