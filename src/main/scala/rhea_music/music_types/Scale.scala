package rhea_music.music_types

import rhea_music.constants.Intervals
import rhea_music.constants.ScaleTypes.ScaleType

/**
  * @author Orestis Melkonian
  */
class Scale(var tone: Tone, scaleType: ScaleType) extends MusicString {

  def getTones: Array[Tone] = Intervals.getTones(tone, scaleType)

  override var repr: String = getTones.map(_.repr).mkString(" ")
}
