 fun main(args: Array<String>) {
    


val (x, y, z) = Triple(3, 2, 5)
when {
x == 0 && y == 0 && z == 0 -> println("Origin")
y == 0 && z == 0 -> println("On the x-axis at x = $x")
x == 0 && z == 0 -> println("On the y-axis at y = $y")
x == 0 && y == 0 -> println("On the z-axis at z = $z")
else -> println("In space at x = $x, y = $y, z = $z")
}

 }