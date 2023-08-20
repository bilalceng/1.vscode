import java.io.File

{
    if (args.isEmpty()) {
        println("[no args]")
    } else {
        println("Args:\n ${args.joinToString("\n ")}")
    }

    var currentFolder = currentFolder()

 

    val folderPrefix = "folder="
    val folderValue = valueFromArgsForPrefix(folderPrefix)

    if (folderValue != null) {
        val folder = File(folderValue).absoluteFile
        folder.printFolderInfo()
    } else {
        println("No path provided, printing working directory info")
        currentFolder().printFolderInfo()
    }

}.invoke()

fun File.folders(): List<File>{
    return this.contents().filter{it.isDirectory}
}

fun File.files(): List<File>{
    return this.contents().filter{it.isFile}
}
fun File.fileNames(): List<String>{
    return this.files().map{it.name}
}

fun File.folderNames(): List<String>{
    return this.folders().map{it.name}
}
fun currentFolder(): File{
    return File("").absoluteFile
}
fun File.contents(): List<File>{
    return this.listFiles().toList()
}


fun File.printFolderInfo(){
    println("contents of ${this.name}: \n")

    if(this.folders().isNotEmpty()){
        println("- Folders: \n ${this.folderNames().joinToString("\n    ")}")
    }

    if (this.files().isNotEmpty()){
        println("- Files: \n ${this.fileNames().joinToString("\n    ")}")
    }

    println("Parent:${this.parentFile.name}")
}


fun valueFromArgsForPrefix(prefix: String): String? {
    val arg = args.firstOrNull { it.startsWith(prefix) }
    if (arg == null) return null
    val pieces = arg.split("=")
    return if (pieces.size == 2) {
        pieces[1]
    } else {
        null
    }
}


