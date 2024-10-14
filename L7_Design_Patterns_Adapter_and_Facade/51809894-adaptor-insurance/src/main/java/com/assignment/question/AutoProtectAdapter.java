package com.assignment.question;

import com.assignment.question.external.AutoProtectApi;
import com.assignment.question.external.AutoProtectStatus;

public class AutoProtectAdapter implements TravelInsuranceAdapter {
  AutoProtectApi autoProtectApi = new AutoProtectApi();

  @Override
  public void submitClaim(String id, Double amount) {
    autoProtectApi.addClaim(amount);
  }

  @Override
  public String getStatus(String id) {
    return autoProtectApi.getStatus(id).toString();
  }
}
