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
    for (halfsteps <- 1 to 15)
      for (mod <- Seq(noNoteMod, s, b))
        buffer += new Interval(halfsteps, mod)
    buffer.toArray
  }

}
