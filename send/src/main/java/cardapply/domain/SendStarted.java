package cardapply.domain;

import cardapply.domain.*;
import cardapply.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class SendStarted extends AbstractEvent {

    private Long userid;
    private Long cardno;
    private String address;
    private Date balsongilja;

    public SendStarted(Send aggregate) {
        super(aggregate);
    }

    public SendStarted() {
        super();
    }
}
//>>> DDD / Domain Event
