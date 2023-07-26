enum class Color(var pass: Boolean = false ){
    RED,
    YELLOW,
    GREEN(true);

    interface Controller{
        fun handleSituation(color: Color)

    }
}

fun main(){
    var handler = object: Color.Controller{
        override fun handleSituation(color: Color) {
            when(color){
                Color.RED -> println("can ı pass: ${color.pass}")
                Color.YELLOW -> println("can ı pass: ${color.pass}")
                Color.GREEN -> println("can ı pass: ${color.pass}")
            }
        }

    }

    val color = Color.RED
    handler.handleSituation(color)
}