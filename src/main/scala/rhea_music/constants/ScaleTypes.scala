package rhea_music.constants

import rhea_music.ImplicitConversions._
import rhea_music.music_types.Interval

/**
  * @author Orestis Melkonian
  */

object ScaleTypes {

  // Type alias
  type ScaleType = Array[Interval]

  // Constants
  val major: ScaleType = "2 3 4 5 6 7"
  val minor: ScaleType = "2 b3 4 5 b6 b7"
  val none: ScaleType = "b2 b3 #4 #5 6 #7"
  // TODO add more scales

  // Array collection
  def allScaleTypes: Array[ScaleType] = Array(
    major, minor
  )
}
