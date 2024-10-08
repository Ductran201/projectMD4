package ra.ecommerceapi.model.entity;

import jakarta.persistence.*;
import lombok.*;
import ra.ecommerceapi.model.base.BaseObject;
import ra.ecommerceapi.model.constant.OrderStatus;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private String code;
    private Double totalPrice;
    private String note;
    private String receiveName;
    private String receiveAddress;
    private String receivePhone;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
