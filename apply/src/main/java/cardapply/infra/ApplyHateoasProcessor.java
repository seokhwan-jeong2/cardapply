package cardapply.infra;

import cardapply.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ApplyHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Apply>> {

    @Override
    public EntityModel<Apply> process(EntityModel<Apply> model) {
        return model;
    }
}
