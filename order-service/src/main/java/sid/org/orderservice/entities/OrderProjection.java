package sid.org.orderservice.entities;

import org.springframework.data.rest.core.config.Projection;
import sid.org.orderservice.status.OrderStatus;

import java.util.Date;

@Projection(name = "fullOrder", types = Order.class)

public interface OrderProjection {


    Long getId();

    Date getCreatedDate();

    OrderStatus getStatus();

    Long getCustomerId();
}
