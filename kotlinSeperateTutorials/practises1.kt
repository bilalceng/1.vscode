class Mymath{
    companion object{
        fun factorial(number:Int):Int{
            return (1..number).fold(1){a:Int,b:Int -> a*b}
        }
        fun factorialCustom(number:Int):Int{
            var multi:Int = 1
            for(i in 1..number){
                multi = multi*i
            }
            return multi
        }

        fun triangleNumbers(number:Int):Int{
            var sum = 0
            for (i in 1..number){
                sum += i
            }
            return sum
        }
    }
}


fun Mymath.Companion.primeFactors(number:Int):List<Int>{
    var remainingValue = number
    var primes = mutableListOf<Int>()
    var testFactor = 2
    while(testFactor * testFactor <= remainingValue){
        if(remainingValue % testFactor == 0){
            primes.add(testFactor)
            remainingValue/=testFactor
        }
        else{
            testFactor ++
        }
    }

        if(testFactor > 1){
            primes.add(testFactor)
        }
        
    
    return primes
}
fun main(){
    println(Mymath.factorial(5))
    println(Mymath.factorialCustom(5))
    println(Mymath.triangleNumbers(7))

   println(Mymath.primeFactors(81))
}