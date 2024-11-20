package cardapply.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "limit", url = "${api.url.limit}")
public interface LimitService {
    @RequestMapping(method = RequestMethod.POST, path = "/limits")
    public void startLimit(@RequestBody Limit limit);
}
