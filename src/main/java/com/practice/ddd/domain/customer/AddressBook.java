package com.practice.ddd.domain.customer;

import com.practice.ddd.domain.common.Address;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AddressBook {

    private String name;
    private Address address;
    private boolean address_default;

}
