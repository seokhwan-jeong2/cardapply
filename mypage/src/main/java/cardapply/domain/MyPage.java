package cardapply.domain;

import cardapply.MypageApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyPage_table")
@Data
//<<< DDD / Aggregate Root
public class MyPage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    private Long cardno;

    private Integer status;

    public static MyPageRepository repository() {
        MyPageRepository myPageRepository = MypageApplication.applicationContext.getBean(
            MyPageRepository.class
        );
        return myPageRepository;
    }
}
//>>> DDD / Aggregate Root
