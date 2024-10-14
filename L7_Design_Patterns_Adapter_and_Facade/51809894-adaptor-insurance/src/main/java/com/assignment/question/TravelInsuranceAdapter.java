package com.assignment.question;

import com.assignment.question.external.AutoProtectStatus;

public interface TravelInsuranceAdapter {
  void submitClaim(String id, Double amount);
  String getStatus(String id);
}