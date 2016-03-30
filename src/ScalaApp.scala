import com.bhargo.enums.Fruit
import Function.uncurried
import java.awt.event.PaintEvent
import scala.util.Random

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
    //varArgs("This","is","a","variable","args","example")

    //an empty list
    //var fruitList = List[Fruit.fruit]()
    var fruitList:List[Fruit.fruit] =List();

    //adding to a list
    for(i <- 0 until 10000) {
      if(i % 4 == 0) {
        fruitList ::= Fruit.MANGO
      } else if(i % 3 == 0) {
        fruitList ::= Fruit.BANANA
      } else if(i % 2 == 0) {
        fruitList ::= Fruit.APPLE
      } else {
        fruitList ::= Fruit.KIWI
      }
    }
    println(fruitList.length)

    //Random.nextInt(5) returns a random num till 4,Seq.fill(25) creates a list of 25
    //val numList = Seq.fill(25)(Random.nextInt(5))

    //println(numList)
    listToMap(fruitList)

    /*var mapp:Map[Fruit.fruit,Int] = Map()
    mapp += (Fruit.MANGO -> 1)
    println(mapp.size)*/
  }

  def listToMap(list:List[Fruit.fruit])={
    var finalMap:Map[Fruit.fruit,Int] = Map()
    var temp:Int = 0
    //val i:Object = null
    list.foreach(
    i => {
      if (finalMap.contains(key = i)) {
        temp = finalMap(i) + 1
        finalMap += (i -> temp)
      } else {
        finalMap += (i -> 1)
      }
    }
    )
    //print("The map is " + finalMap)
    finalMap.keySet.foreach(n => println("Count for fruit " + n + " is " + finalMap(n)))
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
