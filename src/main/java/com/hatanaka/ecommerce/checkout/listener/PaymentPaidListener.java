package com.douglas.ecommerce.checkout.listener;

import com.douglas.ecommerce.checkout.entity.CheckoutEntity;
import com.douglas.ecommerce.checkout.service.CheckoutService;
import com.douglas.ecommerce.checkout.streaming.PaymentPaidSink;
import com.douglas.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent paymentCreatedEvent) {
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
