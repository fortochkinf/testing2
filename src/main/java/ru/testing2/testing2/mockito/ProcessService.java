package ru.testing2.testing2.mockito;

import org.springframework.stereotype.Component;
import ru.testing2.testing2.mockito.dto.Order;
import ru.testing2.testing2.mockito.dto.OrderProcessResult;

@Component
public class ProcessService {

    public OrderProcessResult process(Order order){
        if (order.getId() < 0){
            return OrderProcessResult.ERROR;
        }
        return OrderProcessResult.OK;
    }

}
