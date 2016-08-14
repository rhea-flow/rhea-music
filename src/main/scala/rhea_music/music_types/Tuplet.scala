package rhea_music.music_types

import rhea_music.constants.Ratios.Ratio
import rhea_music.constants.Ratios._

/**
  * @author Orestis Melkonian
  */
class Tuplet(val ratio: Ratio,
             val notes: Note*
            ) extends MusicString {

  override def repr: String = {
    val length = ratio.split(":").map(_.toInt)
    assert(notes.length == length(0))

    var str = ""
    for (note <- notes)
      str += note + "*" + ratio
    str
  }
}

object Tuplet {

  def Triplet(notes: Note*) = new Tuplet(_3_2, notes:_*)

}
