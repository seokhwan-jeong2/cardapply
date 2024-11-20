package cardapply.domain;

import cardapply.domain.*;
import cardapply.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Applied extends AbstractEvent {

    private Long userid;
    private Date sinilja;
    private Long cardno;
    private Integer cardpwd;
    private Long jusaupno;
    private String address;
}
