#MINISERVER
## Description

This project has been created as Spring boot application with Gradle on Java 8. 
Reasons for choosing this technology were: 
- fast way to build up server API for given requirements
- easy to run on every machine where the JRE is installed
- libraries support for the given tasks, such as Apache and Jsoup
- personal knowledge of Java and Spring

## How to run Miniserver

Executable file with needed resources is included in this repository, so you can run for example using following steps.
**JRE is required to run this app.**

1. switch to /exec/ directory on root of this repository
2. run java -jar miniserver.jar

You should be able to access the server on **localhost:8080**.

## Server API
Server APi provides following endpoints

### /current_time

Request:
```
http://localhost:8080/current_time
```

Response example:
```
{
  "responseMessage": "success",
  "data": {
    "currentTimeInMillis": 1563529234298
  }
}
```

### /retrieve_bytes/{numberOfBytes}

Request to retrieve first 20 bytes of file
```
http://localhost:8080/retrieve_bytes/20
```
Response example:
```
{
  "responseMessage": "Success",
  "data": {
    "hex": "255044462d312e340a25d3ebe9e10a312030206f",
    "base64": "JVBERi0xLjQKJdPr6eEKMSAwIG8=",
    "ascii": "%PDF-1.4\n%����\n1 0 o",
    "numberOfBytes": 20
  }
}
```


### /crawl

This endpoint requires JSON request

Request example:
```
{
	"url": "http://www.github.com",
	"depth": 1
}
```

Response:
```
{
  "responseMessage": "Success",
  "data": {
    "content": "<!doctype html>\n<html lang=\"en\">\n <head> \n  <meta charset=\"utf-8\"> \n 
     ... </body>\n</html>"
  }
}
```

### Nice-to-have

* Method for crawling given URL has prepared depth parameter, which will identify the depth of crawling other links on the page to.
