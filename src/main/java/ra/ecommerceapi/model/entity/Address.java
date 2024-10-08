package ra.ecommerceapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import ra.ecommerceapi.model.base.BaseObject;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address extends BaseObject {
    private String fullAddress;
    private String nameReceiver;
    private String phoneReceiver;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
