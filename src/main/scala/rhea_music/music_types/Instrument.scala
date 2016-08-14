package rhea_music.music_types

import rhea_music.constants.Instruments.InstrumentType

/**
  * @author Orestis Melkonian
  */
class Instrument(override val t: InstrumentType) extends Wrapper[InstrumentType](t) {

  override def wrap = t => "I[" + t + "]"
}
