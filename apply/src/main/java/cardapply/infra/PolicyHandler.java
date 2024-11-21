package cardapply.infra;

import cardapply.config.kafka.KafkaProcessor;
import cardapply.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ApplyRepository applyRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Applied'"
    )
    public void wheneverApplied_ApplySaga(@Payload Applied applied) {
        Applied event = applied;
        System.out.println(
            "\n\n##### listener ApplySaga : " + applied + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ApplyCancelled'"
    )
    public void wheneverApplyCancelled_ApplySaga(
        @Payload ApplyCancelled applyCancelled
    ) {
        ApplyCancelled event = applyCancelled;
        System.out.println(
            "\n\n##### listener ApplySaga : " + applyCancelled + "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
