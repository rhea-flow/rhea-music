package rhea_music.cellular_automata

import jm.music.data.CPhrase

/**
  * @author Orestis Melkonian
  */
class HarmonyRange(val xMin: Int, val yMin: Int,
                   val xMax: Int, val yMax: Int,
                   val chord: CPhrase) {

  def inside(x: Int, y: Int): Boolean =
    (xMin to xMax contains x) && (yMin to yMax contains y)
}
