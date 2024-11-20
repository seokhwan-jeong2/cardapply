package cardapply.infra;

import cardapply.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class LimitHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Limit>> {

    @Override
    public EntityModel<Limit> process(EntityModel<Limit> model) {
        return model;
    }
}
