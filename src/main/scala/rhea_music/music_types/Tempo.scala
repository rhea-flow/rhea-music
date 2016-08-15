package rhea_music.music_types

import rhea_music.constants.Tempos.TempoType

/**
  * @author Orestis Melkonian
  */

class wTempo(override val t: TempoType) extends Wrapper[TempoType](t) {

  override def wrap = t => "T" + t
}


