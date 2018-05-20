package sjleibow.music.collection;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
    		@RequestParam(value="salute", defaultValue="Hello") String salute,
    		@RequestParam(value="name", defaultValue="Saxcat") String name
    ) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, salute, name));
    }
}