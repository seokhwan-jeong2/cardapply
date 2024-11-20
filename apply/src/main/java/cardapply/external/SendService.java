package cardapply.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "send", url = "${api.url.send}")
public interface SendService {
    @RequestMapping(method = RequestMethod.POST, path = "/sends")
    public void startSend(@RequestBody Send send);

    @RequestMapping(method = RequestMethod.POST, path = "/sends")
    public void cancelSend(@RequestBody Send send);
}
