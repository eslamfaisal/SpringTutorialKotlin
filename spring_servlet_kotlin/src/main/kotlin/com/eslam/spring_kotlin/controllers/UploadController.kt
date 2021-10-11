package com.eslam.spring_kotlin.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException


@RestController
class UploadController {

   var result: MutableMap<String, Any> = HashMap()

   /// Receive message
   @RequestMapping("/uploadFile")
   @Throws(IOException::class)
   fun upload(@RequestParam("attach") file: MultipartFile): Map<String, Any>? {
      // File info
      println("File name = " + file.originalFilename)
      println("File type = " + file.contentType)

      // Save to disk
      // file path example 1) Windows c:/, 3) Mac ~/Documents/
      val filePath = "c:/Users/eslam/Documents/"
      file.transferTo(File(filePath + file.originalFilename))
      result["Success"] = true
      return result
   }
}
