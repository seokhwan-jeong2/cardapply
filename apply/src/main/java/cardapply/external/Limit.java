package cardapply.external;

import java.util.Date;
import lombok.Data;

@Data
public class Limit {

    private Long userid;
    private Double beforehando;
    private Long cardno;
    private Double afterhando;
    private Date changeilja;
}
