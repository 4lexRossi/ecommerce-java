package com.lexlabs.ecommerce.checkout.service;

import com.lexlabs.ecommerce.checkout.entity.CheckoutEntity;
import com.lexlabs.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
