package com.pivotal.demo.scala.quote
import java.net._
import java.io._
import java.util._
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

/** 
 * Utility for handling JSON
 * @author Joshua Davis
 */
object JsonUtil {
  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
/**
 * converts from String to Json
 */
  def toJson(value: Any): String = {
    mapper.writeValueAsString(value)
  }
/**
 * Converts from Json to a Map
 */
  def toMap[V](json:String)(implicit m: Manifest[V]) = fromJson[Map[String,V]](json)

  /**
   * Converts from Json to a generic class
   */
  def fromJson[T](json: String)(implicit m : Manifest[T]): T = {
    mapper.readValue[T](json)
  }
}