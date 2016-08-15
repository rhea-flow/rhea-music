package rhea_music.music_types

import rhea_music.constants.ScaleTypes.ScaleType
import rhea_music.constants.Tones._
import rhea_music.constants.NoteMods.b

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
class Scale(var tone: Tone, scaleType: ScaleType) {

  def getNotes: Array[Note] = {
    tone.clear()

    var notes = new ArrayBuffer[Note]()
    notes += new Note(tone)

    val tones = if (tone.mod == b) allTonesFlat else allTonesSharp
    val root = tones.indexOf(tone)

    for (interval <- scaleType)
      notes += new Note(tones((root + interval.getOffset) % tones.length))

    notes.toArray
  }
}
