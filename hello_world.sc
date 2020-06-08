object Basics extends App {
  val my_permanent_lucky_number : Int = 51;
  var my_changing_lucky_number : Int = 54;
  var count = 1
  val a_boolean_value = false
  val a_string = "I love Scala!"
  val b_string = "I" + " " + "love "*3 + "Scala!"

  println(a_string)
  println(b_string)

  var interpolated_string = s"My your current lucky number is: $my_changing_lucky_number"
  // Note: You need to use the s to make the string interpolated! Otherwise, it remains text
  println(interpolated_string)

  /*
  Expression vs Value

  Everything in Scala is an expression. That being said, expressions are structures that can be
  reduced to value! The interesting thing is that the 'if' statement is an expression as well
   */

  val an_expression = 3+5-44.0
  val input_string = "kevzl"
  var result_from_if = if (input_string == "keval") 1
  result_from_if = if (input_string == "kewal") 1 else 0
  result_from_if =
    if (input_string == "kewal") 0.5
    else if (input_string == "keval") 1
    else 0

  println(s"Result from if expression: $result_from_if")

  // Code blocks!! - the value of the last expression in a code block is the value of the
  // entire block. This, is also an expression!

  val a_code_block = {
    var local_block_var = 1

    for(i  <- 1 to 50) {
      local_block_var += 1
    }

    local_block_var // This is a valid expression
    var local_block_2 = 11 // This doesn't count as an expression
    local_block_2 - 1 // This is a valid expression
  }

  println(a_code_block)

  // Not let me try and write factorial function from scratch!

  def my_factorial_function_iterative(input_n : Int) : Int = {
    if (input_n <= 1) 1
    else {
      var ans: Int = 1
      for (a <- 1 to input_n) {
        ans *= a
      }
      ans
    }
  }

  def my_factorial_function_recursive(input_n : Int) : Int = {
    if (input_n <= 1) 1
    else {
      input_n*my_factorial_function_recursive(input_n-1)
    }
  }

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  println("Iterative Approach value: ", time {my_factorial_function_recursive(14)})
  println("Iterative Approach value: ", time {my_factorial_function_iterative(14)})

  // We don't use LOOPS or ITERATION in Scala! We use RECURSION!

  // The Unit type !!!

  println("Do I still love Scala!? As long as I am good at recursion!") // returns 'Unit'

  // The above function would return nothing or "void" as in other languages. Scala uses the term
  // "Unit" for such occurrences. type of SIDE EFFECTS - which are functions that do operations
  // such as printing, file write, socket stuff etc.

  def function_returning_unit_or_nothing(input_n: Int) : Unit = {
    printf("I am returning nothing! But Scala still calls it a Unit?!")
  }

  function_returning_unit_or_nothing(44)


}
