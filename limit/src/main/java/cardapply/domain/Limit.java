package cardapply.domain;

import cardapply.LimitApplication;
import cardapply.domain.Limited;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Limit_table")
@Data
//<<< DDD / Aggregate Root
public class Limit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    private Double beforehando;

    private Long cardno;

    private Double afterhando;

    private Date changeilja;

    @PostPersist
    public void onPostPersist() {
        Limited limited = new Limited(this);
        limited.publishAfterCommit();
    }

    public static LimitRepository repository() {
        LimitRepository limitRepository = LimitApplication.applicationContext.getBean(
            LimitRepository.class
        );
        return limitRepository;
    }
}
//>>> DDD / Aggregate Root
