package rhea_music.music_types

import rhea_music.util.constants.Durations.Duration
import rhea_music.util.constants.Durations._
import rhea_music.util.constants.NoteMods.NoteMod
import rhea_music.util.constants.Octaves.Octave
import rhea_music.util.constants.Octaves._
import rhea_music.util.constants.Tones.Tone
import rhea_music.util.constants.Tones._

/**
  * @author Orestis Melkonian
  */
class Note(var tone: Tone = C,
           var mod: NoteMod = "",
           var octave: Octave = _5,
           var duration: Duration = quarter
          ) extends MusicString {

  override def repr: String = tone + mod + octave + duration
}
