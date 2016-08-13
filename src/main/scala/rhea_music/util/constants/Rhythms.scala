package rhea_music.util.constants

import org.jfugue.rhythm.Rhythm.{DEFAULT_RHYTHM_KIT => Drums}

/**
  * @author Orestis Melkonian
  */
object Rhythms {

  def allRhythms: Array[Char] = {
      Drums
        .keySet()
        .toArray(new Array[Character](Drums.size()))
        .map(_.charValue())
  }

  def basicRhythms: Array[Char] = Array(
    '.', 'O', 'S', '^', 'o', 's', '`'
  )

}
