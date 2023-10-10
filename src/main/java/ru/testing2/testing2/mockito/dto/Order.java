package ru.testing2.testing2.mockito.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private Long id;
    private String name;
    private boolean isRequiredToArchive;
    private OrderStatus status;
}
