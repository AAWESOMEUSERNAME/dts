package com.gugu.dts.playlist.inf

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.gugu.dts.**"])
@MapperScan(basePackages = ["com.gugu.dts.**.mapper"])
class TestApplication

fun main(args: Array<String>) {
    runApplication<TestApplication>(*args)
}