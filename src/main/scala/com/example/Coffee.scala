package com.example

import scala.collection.mutable.ArrayBuffer

object Coffee {

	def main(args: Array[String]) {
		val sc = new java.util.Scanner(System.in)
		val a = sc.nextInt()
		val inputBuf = new ArrayBuffer[(Int, Int)](a)
		for(n <- 1 to a){inputBuf += Tuple2(sc.nextInt(), sc.nextInt())}

		var res:(Double, Double) = (0,0)
		inputBuf.foreach(v => res = op(v._1, v._2, res))
		val b = concentration(res)
		println(b)
	}

	def op(_1: Int, _2: Int, coffee:(Double, Double)):(Double, Double) = {
		_1 match{
			case 1 => (coffee._1 + _2, coffee._2)
			case 2 => (coffee._1, coffee._2 + _2)
			case 3 => (coffee._1 - _2 * coffee._1 / (coffee._1 + coffee._2), coffee._2 - _2 * coffee._2 / (coffee._1 + coffee._2))
			case _ => throw new IllegalArgumentException("1,2,3 only")
		}
	}

	def concentration(coffee:(Double, Double)):Int = {
		//		println(coffee._1)
		//		println(coffee._2)
		val res = coffee._2 / (coffee._1 + coffee._2) * 100
		//		println(res)
		res.floor.toInt
	}

}