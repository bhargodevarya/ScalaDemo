import Function.uncurried;

/**
 * Created by barya on 3/30/16.
 */
object ScalaApp {
  def main(args: Array[String]) {
    println (add (2,3))
    println(partialAdd2(5))
    println(callCurriedAdd(9))
    println(curriedAdd(5)(5))
    println(uncurriedAdd(7,7))
    varArgs("This","is","a","variable","args","example")
  }

  def add(a:Int,b:Int):Int=a+b

  //This is a partial function
  def partialAdd2=add(2,_:Int)

  //currying a uncurried function, also as def curriedAdd = (add _).curried
  def curriedAdd: (Int) => (Int) => Int = (add _).curried

  //a curried function
  def curriedAdd2(a:Int)(b:Int):Int = a+b

  //uncurring a curried function
  val uncurriedAdd = Function.uncurried(curriedAdd2 _)

  def callCurriedAdd: (Int) => Int = curriedAdd(2)

  //variable arguments
  def varArgs(args:String*) = args.foreach(println)

}
