package rhea_music.constants

import rhea_music.music_types.Interval
import rhea_music.constants.NoteMods.{noNoteMod, s, b}

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
object Intervals {

  def allIntervals: Array[Interval] = {
    var buffer = new ArrayBuffer[Interval]()
    for (degrees <- 1 to 7)
      for (mod <- Seq(noNoteMod, s, b))
        buffer += new Interval(degrees, mod)
    buffer.toArray
  }

}
