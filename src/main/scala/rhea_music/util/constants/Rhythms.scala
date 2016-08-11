package rhea_music.util.constants

import org.jfugue.rhythm.Rhythm.DEFAULT_RHYTHM_KIT

/**
  * @author Orestis Melkonian
  */
object Rhythms {

  def allRhythms: Array[Char] = {
      DEFAULT_RHYTHM_KIT
        .keySet()
        .toArray(new Array[Character](DEFAULT_RHYTHM_KIT.size()))
        .map(_.charValue())
  }

}
