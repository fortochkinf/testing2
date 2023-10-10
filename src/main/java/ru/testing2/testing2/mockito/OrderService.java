package ru.testing2.testing2.mockito;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.testing2.testing2.mockito.dto.AddOrderResult;
import ru.testing2.testing2.mockito.dto.Order;
import ru.testing2.testing2.mockito.dto.OrderProcessResult;
import ru.testing2.testing2.mockito.dto.OrderStatus;
import ru.testing2.testing2.mockito.exception.OrderAddingException;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderService {

    private final ArchiveService archiveService;

    private final NotificationService notificationService;
    private final DatabaseService databaseService;
    private final ProcessService processService;


    public AddOrderResult addOrderToQueue(Order order){
        order.setStatus(OrderStatus.NEW);
        try {
            if (order.isRequiredToArchive()) {
                archiveService.logOrderToArchive(order);
            }
            notificationService.sendNotification(order);
            databaseService.save(order);
        }catch (Exception ignored){
            throw new OrderAddingException();
        }

        return AddOrderResult.SUCCESS;
    }


    public void processAllOrders(){
        for (var order : databaseService.findAll()){
            if(processService.process(order).equals(OrderProcessResult.OK)){
                order.setStatus(OrderStatus.PROCESSED);
            }else{
                order.setStatus(OrderStatus.ERROR);
            }
        }
    }

    public List<Order> getAllOrders(){
        List<Order> list = databaseService.findAll();
        Collections.shuffle(list);
        return list;
    }

}
