// src/script/scala/progscala3/typelessdomore/Factorial.scala

def factorial(i: Int): Long = {
  def fact(i: Int, accumulator: Long): Long = {
    if (i <= 1) accumulator
    else fact(i - 1, i * accumulator)
  }

  fact(i, 1L)
}

(0 to 5) foreach ( i => println(factorial(i)) )
