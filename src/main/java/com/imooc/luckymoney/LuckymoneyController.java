package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;

    /*
    * 获取红包列表
    * */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return repository.findAll();
    }

    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
        @RequestParam("money") BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setMoney(money);
        luckymoney.setProducer(producer);
        return repository.save(luckymoney);
    }

    @GetMapping("luckymoneys/{id}")
    public Luckymoney getById (@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setId(id);
        luckymoney.setConsumer(consumer);
        return repository.save(luckymoney);
    }
}
