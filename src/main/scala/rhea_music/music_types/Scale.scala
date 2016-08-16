package rhea_music.music_types

import rhea_music.constants.Intervals
import rhea_music.constants.ScaleTypes.ScaleType

/**
  * @author Orestis Melkonian
  */
class Scale(var tone: Tone, scaleType: ScaleType) extends MusicString {

  def getNotes: Array[Note] = Intervals.getNotes(tone, scaleType)

  override var repr: String = getNotes.map(_.repr).mkString(" ")
}
