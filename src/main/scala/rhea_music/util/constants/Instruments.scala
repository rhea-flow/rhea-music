package rhea_music.util.constants

import org.jfugue.rhythm.Rhythm.DEFAULT_RHYTHM_KIT
import org.jfugue.midi.MidiDictionary.{INSTRUMENT_STRING_TO_BYTE => Instr}

/**
  * @author Orestis Melkonian
  */
object Instruments {

  // Type alias
  type InstrumentType = String

  // Constants
  val piano = "Piano"
  val bright = "Bright_Acoustic"
  // TODO add all MIDI instruments


  def allInstruments: Array[String] =
    Instr
      .keySet()
      .toArray(new Array[String](Instr.size()))

}
