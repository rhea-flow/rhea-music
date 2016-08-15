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

  def getNotes(tone: Tone, intervals: Intervals): Array[Note] = {
    tone.clear()

    var notes = new ArrayBuffer[Note]()
    notes += new Note(tone)

    val tones = if (tone.mod == b) allTonesFlat else allTonesSharp
    val root = tones.indexOf(tone)

    for (interval <- intervals)
      notes += new Note(tones((root + interval.getOffset) % tones.length))

    notes.toArray
  }

}
