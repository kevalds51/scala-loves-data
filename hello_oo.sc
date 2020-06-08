package com.rockthejvm

/**
  * This simple application is an invitation to you to play around with any Scala code you like!
  * (not that you'd not be able to create your own application, mind you.)
  *
  * So get creative - test the code that we write in the videos and try new things!
  *
  * Daniel @ Rock the JVM
  */
object Playground extends App {
  println("I love Scala!")
}

object FirstClass extends App {

  // class and instance
  class Car {
    val engine: Double = 2.6
    var color: String = "Gray"

    def start_engine(password: String): Unit = {
      if (password.compareTo("vroomvroom") == 0) {
        println("Vroom Vroom! Engine started")
      }
      else println("Incorrect Key")
    }
  }

  // Inheritance and Constructor
  class Sports_car(engine_size : Double) extends Car {

    // Constructor arguments are not fields unless specified with a 'val' keyword

    // Need to write the keyword 'override' to override methods
    override val engine: Double = engine_size
    override def start_engine(password: String): Unit = {
      if (password.compareTo("boomboom") == 0) {
        println("Boom Boom! Engine started")
      }
      else println("Incorrect Key")
    }
  }

  val mustang = new Car
  mustang.start_engine("vroomvroom")
  val shelby = new Sports_car(5.0)
  shelby.start_engine("boomboom")

  //  shelby.engine_size -> This is not allowed. In-order to save the constructor argument as a member of the class, add
  //  'val' keywork before the constructor argument.

  // Let us look at sub-type polymorphism
  val corvette: Car = new Sports_car(6.9)
  corvette.start_engine("vroomvroom")
  corvette.start_engine("boomboom") // The most derived method will be called at run-time!

  // abstract class

  // In Scala, all the fields and methods are public by default!
  // We can restrict that using private (only this class has access) / protected (this class and its children)

  abstract class Test_car {
    private val has_airbags = false
    def race(): Unit = {}
    // def race(): Unit ^^ same as above
  }

  // "INTERFACE" the ultimate extract type -> keyword TRAIT
  // Basically leave everything unimplemented and denote characteristics of object that we shall implement/use later
  trait Steering {
    def change_steering(): Unit
  }

  trait WD_mode {
    def change_mode(): Unit
  }

  // Scala enables SINGLE-CLASS inheritance and MULTI-TRAIT inheritance as well
  // So basically, a class can only inherit from one class but can inherit multiple traits

  class SUV_car() extends Car with Steering with WD_mode {

    protected var mode = "2WD"
    protected var steering = "normal"

    override def change_mode(): Unit = {
      if (this.mode.equals("2WD")) {
        mode = "4WD"
        println("Changing car mode to 4WD")
      }
      else
      {
        mode = "2WD"
        println("Changing car mode to 2WD")
      }
    }

    override def change_steering(): Unit = {
      if (this.steering.equals("normal")) {
        steering = "off-road"
        println("Changing steering to off-road")
      }
      else
      {
        steering = "normal"
        println("Changing steering to normal")
      }
    }

  }

  val range_rover = new SUV_car()
  range_rover.change_mode()
  range_rover.change_steering()
  range_rover.change_mode()
  range_rover.change_steering()


  // When we create a class that does inheritance as well has trait implementation, it is called "MIXING"!


}