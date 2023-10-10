package ru.testing2.testing2.mockito;

import org.springframework.stereotype.Component;
import ru.testing2.testing2.mockito.dto.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DatabaseService {

    private List<Order> orders = new ArrayList<>();

    public Order save(Order order){
        orders.add(order);
        return order;
    }


    public Order getOrderById(Long id){
        return orders.stream()
            .filter(x -> Objects.equals(x.getId(), id))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Order with id = " + id + " not found"));
    }

    public List<Order> findAll(){
        return orders;
    }



}
