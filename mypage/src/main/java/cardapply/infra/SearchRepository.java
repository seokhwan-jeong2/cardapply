package cardapply.infra;

import cardapply.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "searches", path = "searches")
public interface SearchRepository
    extends PagingAndSortingRepository<Search, Long> {}
