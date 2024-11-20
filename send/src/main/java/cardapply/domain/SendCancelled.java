package cardapply.domain;

import cardapply.domain.*;
import cardapply.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class SendCancelled extends AbstractEvent {

    private Long id;

    public SendCancelled(Send aggregate) {
        super(aggregate);
    }

    public SendCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
