package com.assignment.question;

import com.assignment.question.models.BookingResult;
import com.assignment.question.services.*;

import java.time.LocalDate;

public class BookingManager {
  BookingFacade bookingFacade;

  public BookingManager(AvailabilityService availabilityService, PaymentService paymentService,
                       NotificationService notificationService, LoyaltyService loyaltyService,
                       AccommodationDetailsService accommodationDetailsService) {
    bookingFacade = new BookingFacade(availabilityService, paymentService, notificationService, loyaltyService, accommodationDetailsService);
  }

  public BookingResult bookAccommodation(String userId, String accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
    return bookingFacade.bookAccommodation(userId, accommodationId, checkInDate, checkOutDate);
  }
}
