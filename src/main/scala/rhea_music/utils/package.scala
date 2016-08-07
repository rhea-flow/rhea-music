package rhea_music

/**
  * @author Orestis Melkonian
  */
package object utils {
  /**
    * Maps a value to a different numeric range
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
}
