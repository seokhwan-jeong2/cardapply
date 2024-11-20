package cardapply.domain;

import cardapply.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "limits", path = "limits")
public interface LimitRepository
    extends PagingAndSortingRepository<Limit, Long> {}
