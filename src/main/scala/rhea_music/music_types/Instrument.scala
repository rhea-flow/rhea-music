package rhea_music.music_types

import rhea_music.util.constants.Instruments.InstrumentType

/**
  * @author Orestis Melkonian
  */
class Instrument(override val music: MusicString,
                 override val t: InstrumentType
                  ) extends Wrapper[InstrumentType](music, t) {

  override def wrap = t => "I[" + t + "]"

}
