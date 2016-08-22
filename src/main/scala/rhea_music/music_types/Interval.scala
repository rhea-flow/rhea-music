package rhea_music.music_types

import rhea_music.constants.NoteMods.{NoteMod, getDelta, noNoteMod}

/**
  * @author Orestis Melkonian
  */
class Interval(var degree: Int, var mod: NoteMod = noNoteMod) {

  def getOffset: Int = {
    val base = degree match {
      case 1 | 8 => 0
      case 2 | 9 => 2
      case 3 => 4
      case 4 | 11 => 5
      case 5 => 7
      case 6 | 13 => 9
      case 7 => 11
    }
    base + getDelta(mod)
  }

  override def toString = degree + mod
}
