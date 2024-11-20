package cardapply.domain;

import cardapply.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SendStarted extends AbstractEvent {

    private Long userid;
    private Long cardno;
    private String address;
    private Date balsongilja;
    private Integer status;
}
