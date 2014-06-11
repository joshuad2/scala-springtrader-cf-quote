package com.pivotal.demo.scala.quote

import java.net._
import java.io._
import java.util._
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.{ DeserializationFeature, ObjectMapper }
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

class QuoteClient {

  def getClient(stockName: String) = {

    val loginJson = "{ \"username\":\"vinod\", \"password\":\"pivotal\" }";
    val uri = "http://jdavistraderfront.southeast1.fe.gopivotal.com/api/login"
    val uriQuote = "http://jdavistraderfront.southeast1.fe.gopivotal.com/api/quote/"+stockName

    val url = new URL(uri);
    var connection = url.openConnection().asInstanceOf[HttpURLConnection];

    connection.setDoOutput(true);
    connection.setRequestProperty("Content-Type", "application/json");
    connection.setRequestMethod("POST")
    connection.setRequestProperty("Content-Length", "" + Integer.toString(loginJson.getBytes().length));
    connection.getOutputStream().write(loginJson.getBytes("UTF-8"))
    connection.disconnect();
    var in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
    var sb = new StringBuffer
    var c = "TST"
    while (c != null) {
      c = in.readLine();
      if (c != null) {
        sb.append(c)
      }
    }
    System.out.println(sb.toString())
    val mapper = new ObjectMapper();
    val qu = JsonUtil.fromJson[QuoteUser](sb.toString())

    val quoteUser = qu.asInstanceOf[QuoteUser]
    val urlQuote = new URL(uriQuote);
    connection = urlQuote.openConnection().asInstanceOf[HttpURLConnection];
    connection.setDoOutput(true);
    connection.setRequestProperty("Content-Type", "application/json");
    connection.setRequestMethod("GET")
    connection.setRequestProperty("Content-Length", "0");
    connection.setRequestProperty("API_TOKEN", quoteUser.getAuthToken);
    connection.disconnect();
    var inQuote = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
    sb = new StringBuffer
    c = "TST"
    while (c != null) {
      c = inQuote.readLine();
      if (c != null) {
        sb.append(c)
      }
    }
    sb.toString()
  }
}