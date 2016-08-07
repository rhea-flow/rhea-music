package rhea_music

/**
  * @author Orestis Melkonian
  */
package object util {
  /**
    * Maps a value to a different numeric range.
    *
    * @param inputMin lower bound of x
    * @param inputMax upper bound of x
    * @param outputMin desired lower bound
    * @param outputMax desired upper bound
    * @param x    the value to map (aMin..aMax)
    * @return the mapped value (bMin..bMax)
    */
  def mapRange(inputMin: Double, inputMax: Double,
               outputMin: Double, outputMax: Double,
               x: Double): Double = {
    outputMin + (x - inputMin) * (outputMax - outputMin) / (inputMax - inputMin)
  }

  /**
    * Maps a value to an element of an array.
    *
    * @param inputMin lower bound of x
    * @param inputMax upper bound of x
    * @param x the value to map (aMin..aMax)
    * @param array the array to choose elements from
    * @tparam T the type of the array's values
    * @return the mapped value (an element of the array)
    */
  def mapToArray[T](inputMin: Double, inputMax: Double, x: Double, array: Array[T]): T = {
    val index = mapRange(inputMin, inputMax, 0, array.length - 1, x).toInt
    array(index)
  }

}
