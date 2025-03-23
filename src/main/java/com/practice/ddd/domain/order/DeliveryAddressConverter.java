package com.practice.ddd.domain.order;

import com.practice.ddd.domain.common.Address;
import com.practice.ddd.domain.customer.AddressBook;
import jakarta.persistence.AttributeConverter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeliveryAddressConverter implements AttributeConverter<Address, String> {

    @Override
    public String convertToDatabaseColumn(Address address) {
        if (address == null) throw new RuntimeException("주소 필수");
        return String.format("(%s) %s, %s", address.getPost(), address.getAddress(), address.getAddress_detail());
    }

    @Override
    public Address convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        // 정규 표현식
        String regex = "\\((\\d{5})\\)\\s(.+),\\s(.+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        // 정규 표현식과 매칭되는지 확인
        if (matcher.matches()) {
            String post = matcher.group(1);          // 우편번호
            String address = matcher.group(2);       // 주소
            String addressDetail = matcher.group(3); // 상세주소

            return new Address(post, address, addressDetail);
        } else {
            throw new RuntimeException("주소 형식이 잘못되었습니다.");
        }
    }
}
