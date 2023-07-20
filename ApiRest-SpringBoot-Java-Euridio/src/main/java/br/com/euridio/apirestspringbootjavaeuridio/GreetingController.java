package br.com.euridio.apirestspringbootjavaeuridio;

import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static String template = "hello, %s !";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping
    @RequestMapping("greeting")
    public Greeting greeting (@RequestParam(value = "name",defaultValue = "World") String name){
        return  new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
