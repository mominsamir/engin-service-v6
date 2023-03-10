package com.engin.controller;

import com.engin.App;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class TestController {

    @Autowired
    private JavaSparkContext context;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public List<String> getAssetClassCodes() {

        new App().execute(context.sc());
        final var data
                = Stream.iterate(1, n -> n + 1)
                .limit(5)
                .collect(Collectors.toList());

        final var myRdd = context.parallelize(data);
        System.out.printf("Total elements in RDD: %d%n", myRdd.count());
        System.out.printf("Default number of partitions: %d%n", myRdd.getNumPartitions());

        final var max = myRdd.reduce(Integer::max);
        final var min = myRdd.reduce(Integer::min);
        final var sum = myRdd.reduce(Integer::sum);
        System.out.printf("MAX~>%d, MIN~>%d, SUM~>%d%n", max, min, sum);

        return List.of("Samir");
    }
}
