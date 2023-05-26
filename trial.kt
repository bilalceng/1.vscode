import java.util.*
import kotlin.concurrent.timerTask
import kotlin.system.exitProcess

enum class DownloadState{
    Starting,
    InProgress,
    Error,
    Success;
}

class Downloader{
    private val maxData = 100
    var downloadState:DownloadState? = null
    private var fakeData = mutableListOf<Int>()

    fun downloadData(fromUrl:String , progress: (state:DownloadState?) -> Unit , completion:(error: Error?, data: List<Int>?) -> Unit){
        postProgress(progress)
        downloadState =  DownloadState.Starting
      
    }

  private fun postProgress(progress: (state: DownloadState?) -> Unit){
    progress(downloadState)
    when(downloadState){
        DownloadState.Error -> exitProcess(1)
        DownloadState.Success -> exitProcess(0)
        else -> Timer().schedule(timerTask {postProgress(progress)},200)
    }
  }


}

 fun main(args: Array<String>) {
    Downloader().downloadData("www.cnn.uk", progress = { state ->
        when(state){
            null -> println("no download state yet.")
            DownloadState.Starting -> println("starting download...")
            DownloadState.InProgress -> println("downloading...")
            DownloadState.Error -> println("an error occured while downloading")
            DownloadState.Success -> println("download completed successfully.")
        }
    },
    completion = { error , list ->
        error?.let { println("Got error: ${error.message}") }
        list?.let { println("Got list with ${list.size} items") }

    })
}