package com.gugu.dts.excel.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@Controller
@RequestMapping("excel")
class ExcelController {

    @GetMapping
    fun page(): String{
        return "/upload.html"
    }

    @PostMapping("/upload")
    @ResponseBody
    fun parseExcel(@RequestParam("file") file: MultipartFile):String{
        println("upload")
        return "success"
    }

}