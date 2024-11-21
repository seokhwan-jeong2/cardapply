package cardapply.infra;

import cardapply.config.kafka.KafkaProcessor;
import cardapply.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SearchViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private SearchRepository searchRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenApplied_then_CREATE_1(@Payload Applied applied) {
        try {
            if (!applied.validate()) return;

            // view 객체 생성
            Search search = new Search();
            // view 객체에 이벤트의 Value 를 set 함
            search.setUserid(applied.getUserid());
            search.setCardno(applied.getCardno());
            // view 레파지 토리에 save
            searchRepository.save(search);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSendStarted_then_UPDATE_1(
        @Payload SendStarted sendStarted
    ) {
        try {
            if (!sendStarted.validate()) return;
            // view 객체 조회
            Optional<Search> searchOptional = searchRepository.findByUserid(
                sendStarted.getUserid()
            );

            if (searchOptional.isPresent()) {
                Search search = searchOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                search.setStatus(sendStarted.getStatus());
                // view 레파지 토리에 save
                searchRepository.save(search);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
