# Furl keep-alive bug demonstration

To reproduce:

* install scala's sbt: http://www.scala-sbt.org/download.html
* (in this directory) `sbt run`
* (in a second terminal window) `./furlTest.pl`

# Example output

```
$ ./furlTest.pl
GET #1 successful.
Sleeping 1 sec
GET #2 successful.
Sleeping 3 sec
GET #3 successful.
Sleeping 6 sec
GET #4 failed. at ./furlTest.pl line 26.
```
