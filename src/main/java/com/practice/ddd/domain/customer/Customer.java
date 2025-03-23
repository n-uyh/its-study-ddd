package com.practice.ddd.domain.customer;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    private String id;

    @Embedded
    @AttributeOverride(name = "password", column = @Column(name="pw"))
    private Password pw;

    private String name;

    @ElementCollection(fetch= FetchType.LAZY)
    @CollectionTable(
        name = "address_book",
        joinColumns = @JoinColumn(name="customer_id")
    )
    @OrderColumn(name = "address_order")
    private List<AddressBook> addressBook;

}
