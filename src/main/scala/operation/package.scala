import java.io.File
import scala.annotation.tailrec
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

package object operation {
  val sleepTime = 100

  def scanDirectory(Directory: File): Future[List[File]] = Future {
    @tailrec
    def checkForFiles(fileList: List[File], Directory: List[File]): List[File] = {
      Directory match {
        case Nil => fileList
        case file :: restOfContents => {
          file.isDirectory match {
            case false => checkForFiles(file :: fileList, restOfContents)
            case true => checkForFiles(fileList, restOfContents ::: file.listFiles.toList)
          }
        }
      }
    }
    checkForFiles(List(), List(Directory))
  }
}
