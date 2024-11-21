package cardapply.domain;

import cardapply.ApplyApplication;
import cardapply.domain.Applied;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Apply_table")
@Data
//<<< DDD / Aggregate Root
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    private Date sinilja;

    private Long cardno;

    private Integer cardpwd;

    private Long jusaupno;

    private String address;

    @PostPersist
    public void onPostPersist() {
        Applied applied = new Applied(this);
        applied.publishAfterCommit();
    }

    public static ApplyRepository repository() {
        ApplyRepository applyRepository = ApplyApplication.applicationContext.getBean(
            ApplyRepository.class
        );
        return applyRepository;
    }

   @PreRemove
    public void onPreRemove() {
        ApplyCancelled applyCancelled = new ApplyCancelled(this);
        applyCancelled.publishAfterCommit();
    }

}
//>>> DDD / Aggregate Root
