
import java.util.*
import kotlin.concurrent.timerTask
import kotlin.system.exitProcess

enum class DownloadState {
  Idle,
  Starting,
  InProgress,
  Error,
  Success;
}

class Downloader {

  private val maxData = 100
  var downloadState: DownloadState? = null
  private var fakeData: MutableList<Int> = mutableListOf()

  fun downloadData(fromUrl: String, progress: (state: DownloadState?) -> Unit, completion: (error:Error ?, data: List<Int>?) -> Unit) {
    println("\"Downloading\" from URL: ${fromUrl}")
    postProgress(progress)
    downloadState = DownloadState.Starting
    keepAddingData(completion)
  }

  private fun keepAddingData(completion: (error: Error?, data: List<Int>?) -> Unit) {
    addMoreData { error ->
      when (downloadState) {
        DownloadState.Error -> completion(error, null)
        DownloadState.Success -> completion(null, fakeData.toList())
        else -> keepAddingData(completion)
      }
    }
  }

  private fun postProgress(progress: (state: DownloadState?) -> Unit) {
    progress(downloadState)
      println("*******")
    when (downloadState) {
      DownloadState.Error -> exitProcess(1)
      DownloadState.Success -> exitProcess(0)
      else -> Timer().schedule(timerTask { postProgress(progress) }, 200)
    }
  }

  private fun addMoreData(completion: (error: Error?) -> Unit) {
    Timer().schedule(timerTask {
      val error = randomlyThrowError()
      if (error != null) {
        downloadState = DownloadState.Error
        completion(error)
      } else {
        downloadState = DownloadState.InProgress
        for (i in 0..20) {
          fakeData.add(i)
          if (fakeData.size == maxData) {
            downloadState = DownloadState.Success
            break
          }
        }

        completion(null)
      }
    }, 500)
  }

  private fun randomlyThrowError(): Error? {
    val randomNumber: Int = (0..10).random()
    if (randomNumber == 2) {
      return Error("Your download was eaten by a shark.")
    } else {
      return null
    }
  }
}




fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start

    fun main(){

        Downloader().downloadData("foo.com/bar",
        progress = { downloadState ->
          when (downloadState) {
            null -> println("No download state yet")
            DownloadState.Starting -> println("Starting download...")
            DownloadState.InProgress -> println("Downloading data...")
            DownloadState.Error -> println("An error occurred. Download terminated.")
            DownloadState.Success -> println("Download completed successfully.")
          }
        },
        completion = { error, list ->
          error?.let { println("Got error: ${error.message}") }
          list?.let { println("Got list with ${list.size} items") }
        })
        
}