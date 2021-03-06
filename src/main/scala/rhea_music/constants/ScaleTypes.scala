package rhea_music.constants

import rhea_music.util.ImplicitConversions._
import rhea_music.constants.Intervals.Intervals

/**
  * @author Orestis Melkonian
  */

object ScaleTypes {

  // Type alias
  type ScaleType = Intervals

  // Constants
  val major: ScaleType = "2 3 4 5 6 7"
  val minor: ScaleType = "2 b3 4 5 b6 b7"
  val lydian: ScaleType = "2 3 #4 5 6 7"
  val harmonicMinor: ScaleType = "2 b3 4 5 b6 7"
  val melodicMinor: ScaleType = "2 b3 4 5 6 7"
  val japanese: ScaleType = "2 #3 #4 #5 6 7"
  val none: ScaleType = "b2 b3 #4 #5 6 #7"
  // TODO add more scales

  // Array collection
  def allScaleTypes: Array[ScaleType] = Array(
    major, minor
  )
}
