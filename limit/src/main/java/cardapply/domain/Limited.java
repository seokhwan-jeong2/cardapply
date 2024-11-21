package cardapply.domain;

import cardapply.domain.*;
import cardapply.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Limited extends AbstractEvent {

    private Long userid;
    private Double beforehando;
    private Long cardno;
    private Double afterhando;
    private Date changeilja;
    private Integer status;

    public Limited(Limit aggregate) {
        super(aggregate);
    }

    public Limited() {
        super();
    }
}
//>>> DDD / Domain Event
