package ru.testing2.testing2.mockito;

import org.springframework.stereotype.Component;
import ru.testing2.testing2.mockito.dto.Order;

@Component
public class NotificationService {

    public void sendNotification(Order order){
        throw new IllegalStateException("Cant't send notification");
    }

}
