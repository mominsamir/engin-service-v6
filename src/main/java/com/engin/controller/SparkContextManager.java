package com.engin.controller;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.IOException;
import java.nio.file.Files;

/**
 * @author jeltok
 */
@Configuration
public class SparkContextManager {

    @Bean
    public SparkConf localSparkConf() throws IOException {
        var conf = new SparkConf()
                .setAppName("Engin")
                .setMaster("local[4]");
/*        conf.set("spark.ui.retainedJobs", "0");
        conf.set("spark.ui.retainedStages", "0");
        conf.set("spark.worker.ui.retainedExecutors", "0");
        conf.set("spark.worker.ui.retainedDrivers", "0");
        conf.set("spark.sql.ui.retainedExecutions", "0");*/
        return conf;
    }



    @Bean
    public JavaSparkContext javaSparkContext(SparkConf sparkConf) {
        return new JavaSparkContext(sparkConf);
    }

    @Bean
    public SparkSession sparkSession(JavaSparkContext sparkContext) {
        return SparkSession.builder()
                .sparkContext(sparkContext.sc())
                .config(sparkContext.getConf())
                .getOrCreate();
    }

}
