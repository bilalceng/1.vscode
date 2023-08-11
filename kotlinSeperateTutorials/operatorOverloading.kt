class Company(val name: String){
    val allEmployees: List<Employee>
        get() = arrayListOf<Employee>().apply {
            departments.forEach{
                addAll(it.employees)
                sort()
            }
        }
    var departments: ArrayList<Department> = arrayListOf()
 }
 
 class Department(var name: String): Iterable<Employee>{
     var employees: ArrayList<Employee> = arrayListOf()
     override fun iterator(): Iterator<Employee> {
         return employees.iterator()
     }
 
     fun hire(list: List<Employee>):List<Employee>{
         employees.addAll(list)
         return list
     }
 
 }
 
 
 data class Employee(val company: Company,
     val name: String,
     var salary: Double): Comparable<Employee>{
     override fun compareTo(other: Employee): Int {
        return when (other) {
            this -> 0
            else -> name.compareTo(other.name)
        }
     }
 
 }
 
 
 
 //Employee operator functions.
 
 operator  fun Employee.inc():Employee{
     salary += 5000
     return this
 }
 
 operator fun Employee.dec():Employee{
     salary -= 500
     return this
 }
 
 operator fun Employee.minusAssign(decreaseValue: Double){
     salary -= decreaseValue
 
 }
 
 operator fun Employee.plusAssign(increaseValue: Double){
     salary += increaseValue
 }
 //Company operator functions
 
 operator fun Company.plusAssign(department: Department){
     departments.add(department)
     println("new ${department.name} is opened")
 }
 
 operator fun Company.minusAssign(department: Department){
     departments.remove(department)
     println("new ${department.name} is closed")
 }
 
 
 operator fun Employee.rangeTo(other: Employee): List<Employee>{
     var currentIndex = company.allEmployees.indexOf(this)
     var lastIndex = company.allEmployees.indexOf(other)
 
     if (currentIndex >= lastIndex){
         return emptyList()
     }
     return company.allEmployees.slice(currentIndex..lastIndex)
 }
 //department operator functions
 operator fun Department.plusAssign(employee: Employee){
     employees.add(employee)
     println("new ${employee.name} is hired")
 }
 
 operator fun Department.minusAssign(employee: Employee){
     employees.remove(employee)
     println(" ${employee.name} is fired")
 }
 
 operator fun Department.get(element: Int):Employee?{
     return if (element < employees.size){
         employees[element]
     }else{
         null
     }
 }
 
 operator fun Employee.plus(other: Employee): ArrayList<Employee>{
     var employeeList = arrayListOf<Employee>()
 
         employeeList.add(other)
         employeeList.add(this)
 
     return employeeList
 }
 
 operator fun Department.set(index:Int, employee: Employee){
     if (index < employees.size){
         employees[index] = employee
     }
 }
 
 operator fun Department.contains(employee: Employee): Boolean{
     for (staff in this){
         if (staff == employee){
             return true
         }
     }
     return false
 }
 
 
 
 fun main(){
     var company  = Company("myOwnCompany")
 
     var developmentDepartment = Department("Development")
     var qaDepartment = Department("Quality Assurance")
     var hrDepartment  = Department("Human Resources")
 
     var Julia = Employee(company, "Julia", 100_000.0)
 
     var John = Employee(company, "John", 86_000.0)
     var Peter = Employee(company, "Peter", 100_000.0)
     var Sandra = Employee(company, "Sandra", 75_000.0)
     var Thomas = Employee(company, "Thomas", 73_000.0)
     var Alice = Employee(company, "Alice", 70_000.0)
     var Bernadette = Employee(company, "Bernadette", 66_000.0)
     var Mark = Employee(company, "Mark", 66_000.0)
 
     ++Julia
     Julia++
     println(Julia.salary)
     Julia--
     Julia -= 2000.0
     println(Julia.salary)
     Julia += 40000.0
     println(Julia.salary)
 
 
     company += developmentDepartment
     company += qaDepartment
     company += hrDepartment
     developmentDepartment += Julia
     developmentDepartment += John
     developmentDepartment += Peter
     qaDepartment += Sandra
     qaDepartment += Thomas
     qaDepartment += Alice
     hrDepartment += Bernadette
     hrDepartment += Mark
     qaDepartment -= Thomas
 
     val firstEmployee = developmentDepartment[0]
     firstEmployee?.let {
         it += 20000.0
     }
 
     println(developmentDepartment[0]?.salary)
 
     developmentDepartment[2] = Thomas
 
     println( developmentDepartment[3])
 
     if (Thomas in developmentDepartment){
         println("true")
     }
 
     println((Alice..Julia).joinToString { it.name })
 
     var Susan = Employee(company, "Susan", 70_000.0)
     var Jack = Employee(company, "Jack", 66_000.0)
     var Jeff = Employee(company, "Jeff", 66_000.0)
 
     println( developmentDepartment.hire(Susan + Jack + Jeff))
 
     for (employee in developmentDepartment){
         println(employee.name)
     }
     println(developmentDepartment.employees)
     println( developmentDepartment.hire(Susan + Jack + Jeff))
 }