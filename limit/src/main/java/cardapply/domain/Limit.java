package cardapply.domain;

import cardapply.LimitApplication;
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

    public static LimitRepository repository() {
        LimitRepository limitRepository = LimitApplication.applicationContext.getBean(
            LimitRepository.class
        );
        return limitRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startLimit(Applied applied) {
        //implement business logic here:

        /** Example 1:  new item 
        Limit limit = new Limit();
        repository().save(limit);

        Limited limited = new Limited(limit);
        limited.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(applied.get???()).ifPresent(limit->{
            
            limit // do something
            repository().save(limit);

            Limited limited = new Limited(limit);
            limited.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
