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
    Repository Repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Applied'"
    )
    public void wheneverApplied_StartSend(@Payload Applied applied) {
        Applied event = applied;
        System.out.println(
            "\n\n##### listener StartSend : " + applied + "\n\n"
        );

        // Sample Logic //
        Send.startSend(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
