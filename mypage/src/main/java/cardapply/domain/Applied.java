package cardapply.domain;

import cardapply.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class Applied extends AbstractEvent {

    private Long userid;
    private Date sinilja;
    private Long cardno;
    private Integer cardpwd;
    private Long jusaupno;
    private String address;
}
