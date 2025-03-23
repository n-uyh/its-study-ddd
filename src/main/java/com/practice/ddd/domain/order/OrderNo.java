package com.practice.ddd.domain.order;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderNo implements Serializable {

    private String no;

    public static OrderNo create() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyMMdd__HHmmss");
        return new OrderNo("O"+df.format(LocalDateTime.now()));
    }

}
