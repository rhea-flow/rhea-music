package rhea_music.music_types

import rhea_music.util.constants.Tempos.TempoType

/**
  * @author Orestis Melkonian
  */

class Tempo(override val music: MusicString,
            override val t: TempoType
           ) extends Wrapper[TempoType](music, t) {

  override def wrap = t => "T" + t
}


