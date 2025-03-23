package com.practice.ddd.domain.order;

import com.practice.ddd.domain.common.Address;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "order_info")
public class Order {

    @EmbeddedId
    private OrderNo id;

    @Convert(converter = DeliveryAddressConverter.class)
    private Address delivery_address;

}
