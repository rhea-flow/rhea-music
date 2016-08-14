package rhea_music.music_types

import rhea_music.constants.NoteMods.{NoteMod, getDelta}
import rhea_music.constants.Tones.Tone

/**
  * @author Orestis Melkonian
  */
class Interval(var halfsteps: Int, var mod: NoteMod) {

  def getHalfsteps: Int =
    halfsteps + getDelta(mod)

  def getTone(tone: Tone): Tone = ??? // TODO Note::transpose
}

object Interval {

  implicit def stringToInterval(s: String): Interval = new Interval(s.take(1).toInt, s.drop(1))

  implicit def stringsToIntervals(s: String): Array[Interval]= s.split(" ").map(i => stringToInterval(i))

}
