package cardapply.domain;

import cardapply.domain.*;
import cardapply.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ApplyCancelled extends AbstractEvent {

    private Long userid;
    private Date cancelilja;
    private String status;
    private Long cardno;

    public ApplyCancelled(Apply aggregate) {
        super(aggregate);
    }

    public ApplyCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
