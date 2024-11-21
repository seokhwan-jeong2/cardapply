package cardapply.infra;

import cardapply.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class SendHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Send>> {

    @Override
    public EntityModel<Send> process(EntityModel<Send> model) {
        return model;
    }
}
