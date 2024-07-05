import scalaj.http._

object RetryWithBackoff {
  def retry[T](max: Int, delay: Int)(f: => T): T = {
    var tries = 0
    var result: Option[T] = None
    while (result.isEmpty) {
      try {
        result = Some(f)
      } catch {
        case e: Throwable =>
          tries += 1
          if (tries > max) throw e
          else {
            println(s"failed, retry #$tries")
            Thread.sleep(delay)
          }
      }
    }
    result.get
  }

  val httpbin = "https://httpbin.org"

  def main(args: Array[String]): Unit = {
    retry(max = 10, delay = 1000) {
      // Only succeeds with a 200 response
      // code 1/3 of the time
      val response = Http(s"$httpbin/status/200,400,500").asString
      if (response.is2xx) {
        println("Success")
      } else {
        throw new RuntimeException("Request failed")
      }
    }
  }
}
