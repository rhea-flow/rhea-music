package rhea_music.music_types

import rhea_music.constants.Intervals
import rhea_music.constants.ScaleTypes.ScaleType

/**
  * @author Orestis Melkonian
  */
class Scale(var tone: Tone, scaleType: ScaleType) {

  def getNotes = Intervals.getNotes(tone, scaleType)
}
