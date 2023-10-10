package ru.testing2.testing2.mockito;

import org.springframework.stereotype.Component;
import ru.testing2.testing2.mockito.dto.Order;

@Component
public class ArchiveService {

    public void logOrderToArchive(Order order){
        throw new IllegalStateException("Archive server is not online");
    }

}
