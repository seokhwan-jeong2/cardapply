package cardapply.domain;

import cardapply.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "applies", path = "applies")
public interface ApplyRepository
    extends PagingAndSortingRepository<Apply, Long> {}
