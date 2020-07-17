package com.lexlabs.ecommerce.checkout.listener;

import com.lexlabs.ecommerce.checkout.entity.CheckoutEntity;
import com.lexlabs.ecommerce.checkout.service.CheckoutService;
import com.lexlabs.ecommerce.checkout.streaming.PaymentPaidSink;
import com.lexlabs.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    public PaymentPaidListener(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent paymentCreatedEvent) {
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
