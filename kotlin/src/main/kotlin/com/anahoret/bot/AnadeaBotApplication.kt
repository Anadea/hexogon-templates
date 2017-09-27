package com.anahoret.bot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AnadeaBotApplication {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(AnadeaBotApplication::class.java)
    }
  }

}
