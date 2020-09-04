package com.gugu.dts.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DtsApplication

fun main(args: Array<String>) {
    runApplication<DtsApplication>(*args)
}
