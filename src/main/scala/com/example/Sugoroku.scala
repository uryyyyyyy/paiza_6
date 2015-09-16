package com.example

import scala.collection.mutable.{HashSet, ArrayBuffer}

object Sugoroku {

	def main(args: Array[String]) {
		val sc = new java.util.Scanner(System.in)
		val a = sc.nextInt()
		val masuList = new ArrayBuffer[Int](a)
		for(n <- 1 to a){masuList += sc.nextInt()}

		val b = sc.nextInt()
		val demeList = new ArrayBuffer[Int](b)
		for(n <- 1 to b){demeList += sc.nextInt()}

		demeList.map(v => Calculator.canGoal(v, masuList, new HashSet[Int]))
			.foreach(v => if(v) println("Yes") else println("No"))
	}

}

object Calculator{


	def canGoal(v: Int, masuList: ArrayBuffer[Int], footprints:HashSet[Int]): Boolean = {
		println(v)
		if(v == masuList.length-1) return true
		try{
			masuList(v) match{
				case 0 => false
				case vv => {
					val newMasu = v+vv
					if(footprints.contains(newMasu)) false else {
						footprints += newMasu
						canGoal(newMasu, masuList, footprints)
					}
				}
			}
		}catch{
			case e:IndexOutOfBoundsException => false
		}
	}
}