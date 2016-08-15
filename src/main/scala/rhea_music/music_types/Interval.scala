package rhea_music.music_types

import rhea_music.constants.NoteMods.{NoteMod, getDelta, noNoteMod}

/**
  * @author Orestis Melkonian
  */
class Interval(var degree: Int, var mod: NoteMod = noNoteMod) {

  // TODO get enharmonic
  def getOffset: Int =
    degree match {
      case 1 => 0
      case 2 => 2
      case 3 => 4
      case 4 => 5
      case 5 => 7
      case 6 => 9
      case 7 => 11
    }
    + getDelta(mod)

}
