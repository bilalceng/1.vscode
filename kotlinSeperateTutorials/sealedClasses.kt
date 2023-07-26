sealed class Result<T> {
    abstract class ResultHandler{
        abstract fun handleResult(result: Result<Double>)

    }
    var message: T? = null
    var data: T? = null
    class Success<T>() : Result<T>(){
        /*fun processSuccessEvent(): String?{
            if (data == 50.0){
                return "data is equal treshold: $data"
            }
            return null
        }
    }*/
}

    class Error<T> : Result<T>()
    class Loading<T> : Result<T>()
}




sealed class Resource(var message: String? = null, var data: String? = null){
    class Success(message: String): Resource(message)
    class Error(): Resource()
    object Loading: Resource()
}

sealed class Shape(var radius: Double? = null , var sideLength: Double? = null) {
    class Circle(radius: Double): Shape(radius)
    class Square( sideLength: Double): Shape(sideLength)
}


fun main(){
    var resource: Resource = Resource.Success("here is the message")
    val result: Result<Double> = Result.Error()
    result.message = 404.0
    processResult(result)
    println(resource.message)

}

private fun processResult(result: Result<Double>){

    var resultGHandler = object : Result.ResultHandler(){
        override fun handleResult(result: Result<Double>) {

            when(result){
                is Result.Success -> {
                    println("handling success: ${result.data}")
                }

                is Result.Error -> {

                    println("handling error: ${result.message}")
                }

                is Result.Loading -> {

                    println("handling loading...")
                }
            }
        }



    }

    resultGHandler.handleResult(result)
}