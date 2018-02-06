import operation._
import java.io.File
import org.apache.log4j.Logger
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Application extends App {
  val Log = Logger.getLogger(this.getClass)
  val file = new File("/home/knoldus/Documents")
  scanDirectory(file).onComplete {
    case Success(result) => Log.info(s"\nDirectory has been located\nResult :- \n"); result.foreach((file) => Log.info(s"$file \n"))
    case Failure(result) => Log.info(s"Error:- ${result.getMessage}")
  }
  Thread.sleep(sleepTime)
}
