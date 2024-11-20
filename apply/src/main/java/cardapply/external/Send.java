package cardapply.external;

import java.util.Date;
import lombok.Data;

@Data
public class Send {

    private Long userid;
    private Long cardno;
    private String address;
    private Date balsongilja;
}
