package com.example

object Houshu {

	def calc(t: (Int, Int)):Int = {
		(t._1*10 + t._2) + t._1 + t._2
	}

	def main(args: Array[String]) {
		val sc = new java.util.Scanner(System.in)
		val a = sc.nextInt()
		if(a/100 > 0) throw new IllegalArgumentException
		val tuple:(Int, Int) = (a/10 , a - a/10*10)
		val b = calc(tuple)
		println(b)
	}

}