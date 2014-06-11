package com.pivotal.demo.scala.quote

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import org.junit.Test
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.annotation.JsonInclude.Include
import java.io.StringReader
class TestQuote{
case class User(authToken:String, profileId:Int, accountId:Int)
@Test def testQuote(){
  var qc=new QuoteClient
  qc.getClient("DELL")
}
  
@Test def testJson(){
  val sb="{  \"authToken\" : \"d2a21e64-a9cd-47b7-94fd-e1998723fea6\",  \"profileid\" : 1,  \"accountid\" : 1}"
  val mapper=new ObjectMapper();
  mapper.setSerializationInclusion(Include.NON_NULL);
  val qu=mapper.readValue(new StringReader(sb),classOf[QuoteUser])
  if (qu!=null){
    assert(true)
  }
  else assert(false)
}

@Test def testJsonGeneric(){
  val sb="{  \"authToken\" : \"d2a21e64-a9cd-47b7-94fd-e1998723fea6\",  \"profileid\" : 1,  \"accountid\" : 1}"
  val mapper=new ObjectMapper();
  mapper.setSerializationInclusion(Include.NON_NULL);
  val qu=JsonUtil.fromJson[QuoteUser](sb)
  if (qu!=null){
    assert(true)
  }
  else assert(false)
}

}