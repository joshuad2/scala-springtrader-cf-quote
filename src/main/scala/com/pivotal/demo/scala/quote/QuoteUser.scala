package com.pivotal.demo.scala.quote

class QuoteUser{
  //case class User(authToken:String, profileId:Int, accountId:Int)
 var authToken:String="";
  var profileid:Int=0;
var accountid:Int=0;
 
 def getAuthToken(): String={
    return authToken
 }
 
 def setAuthToken(pAuthToken:String){
   this.authToken = pAuthToken;
 }
 
 def getProfileid():Int={
   return profileid
 }
 
 def setProfileId(pProfileid:Int){
   this.profileid =pProfileid;
 }
 
 def getAccountid():Int={
   return accountid
 }
 
 def setAccountid(pAccountid:Int){
   this.accountid = pAccountid
 }
 
}