package com.example

import org.scalatest.FunSuite

import scala.collection.mutable.{HashSet, ArrayBuffer}

class Calculator$Test extends FunSuite {

	test("testCanGoal") {
		val masuList = ArrayBuffer(0, 6,-2, -2, 0, 1, -1, 0)
		assert(Calculator.canGoal(7, masuList, new HashSet[Int]))
		assert(!Calculator.canGoal(6, masuList, new HashSet[Int]))
		assert(Calculator.canGoal(3, masuList, new HashSet[Int]))
		assert(!Calculator.canGoal(8, masuList, new HashSet[Int]))
		assert(!Calculator.canGoal(9, masuList, new HashSet[Int]))
	}

	test("testCanGoal2") {
		val masuList = ArrayBuffer(0, 1, 2, 0, 0)
		assert(Calculator.canGoal(1, masuList, new HashSet[Int]))
		assert(Calculator.canGoal(2, masuList, new HashSet[Int]))
		assert(!Calculator.canGoal(3, masuList, new HashSet[Int]))
		assert(Calculator.canGoal(4, masuList, new HashSet[Int]))
		assert(!Calculator.canGoal(5, masuList, new HashSet[Int]))
	}

}
