package sid.org.orderservice.entities;

import lombok.*;
import sid.org.orderservice.model.Customer;
import sid.org.orderservice.status.OrderStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdDate;
    private OrderStatus status;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;


    public double getTotal(){
        double somme=0;

        for(ProductItem pi : productItems){
            somme+=pi.getAmount();
        }
        return somme;
    }
}
