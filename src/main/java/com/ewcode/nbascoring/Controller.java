package com.ewcode.nbascoring;


import com.ewcode.nbascoring.infra.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    private final Producer producer;

    public Controller(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/produce")
    public String ping() {
        System.out.println("producing");
        for(int i = 0; i < 1000; i++) {
            producer.send("test", "mensagem =" +(i+ 1) );
        }

        System.out.println("produced");
        return "test";
    }

}
