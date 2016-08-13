package rhea_music.util.constants

import org.jfugue.rhythm.Rhythm.DEFAULT_RHYTHM_KIT
import org.jfugue.midi.MidiDictionary.{INSTRUMENT_STRING_TO_BYTE => Instr}

/**
  * @author Orestis Melkonian
  */
object Instruments {

  def allInstruments: Array[String] = {
    Instr
      .keySet()
      .toArray(new Array[String](Instr.size()))
  }

}
