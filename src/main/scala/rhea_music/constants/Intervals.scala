package rhea_music.constants

import rhea_music.constants.Tones._
import rhea_music.music_types.{Interval, Note, Tone}
import rhea_music.constants.NoteMods.{b, noNoteMod, s}

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
object Intervals {

  type Intervals = Array[Interval]

  def allIntervals: Array[Interval] = {
    var buffer = new ArrayBuffer[Interval]()
    for (degrees <- 1 to 7)
      for (mod <- Seq(noNoteMod, s, b))
        buffer += new Interval(degrees, mod)
    buffer.toArray
  }

  def getTones(tone: Tone, intervals: Intervals): Array[Tone] = {
    tone.clear()

    var ret = new ArrayBuffer[Tone]()
    ret += tone

    val tones = if (tone.mod == b) allTonesFlat else allTonesSharp // FIXME smart check
    val root = tones.indexOf(tone)

    for (interval <- intervals)
      ret += tones((root + interval.getOffset) % tones.length)

    ret.toArray
  }

}
