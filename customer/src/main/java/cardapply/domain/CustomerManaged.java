package cardapply.domain;

import cardapply.domain.*;
import cardapply.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CustomerManaged extends AbstractEvent {

    private Long userid;
    private Long jusaupno;
    private Integer customergubun;
    private String address;

    public CustomerManaged(Customer aggregate) {
        super(aggregate);
    }

    public CustomerManaged() {
        super();
    }
}
//>>> DDD / Domain Event
