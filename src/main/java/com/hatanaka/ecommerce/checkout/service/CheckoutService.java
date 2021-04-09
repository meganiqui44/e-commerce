package com.douglas.ecommerce.checkout.service;

import com.douglas.ecommerce.checkout.entity.CheckoutEntity;
import com.douglas.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
