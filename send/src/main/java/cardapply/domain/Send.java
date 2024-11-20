package cardapply.domain;

import cardapply.SendApplication;
import cardapply.domain.SendStarted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Send_table")
@Data
//<<< DDD / Aggregate Root
public class Send {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    private Long cardno;

    private String address;

    private Date balsongilja;

    private Integer status;

    @PostPersist
    public void onPostPersist() {
        SendStarted sendStarted = new SendStarted(this);
        sendStarted.publishAfterCommit();
    }

    public static SendRepository repository() {
        SendRepository sendRepository = SendApplication.applicationContext.getBean(
            SendRepository.class
        );
        return sendRepository;
    }
}
//>>> DDD / Aggregate Root
