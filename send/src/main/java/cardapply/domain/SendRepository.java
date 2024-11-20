package cardapply.domain;

import cardapply.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "sends", path = "sends")
public interface SendRepository
    extends PagingAndSortingRepository<Send, Long> {}
