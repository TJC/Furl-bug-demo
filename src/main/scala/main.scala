package net.dryft.demo
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object WebServer extends Directives {
  def main(args: Array[String]) {
    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val route =
      path("") {
        get {
          complete(HttpResponse(200, entity = "ok"))
        }
      } ~
      path("ping") {
        get {
          complete(HttpResponse(200, entity = "pong"))
        }
      } ~
      {
        complete(HttpResponse(404, entity = "whaaaaa?"))
      }

      val bindingFuture = Http().bindAndHandle(route, "0.0.0.0", 8080)

      println("Server online at http://localhost:8080/")
      println("Hit Ctrl-C to exit")
  }
}
