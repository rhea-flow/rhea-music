package rhea_music.cellular_automata

import rhea_music.utils.constants.Chords._
import jm.music.data.CPhrase

/**
  * @author Orestis Melkonian
  */
class HarmonyMapper(val ranges: HarmonyRange*) {
  def map(x: Int, y:Int): CPhrase = {
    for (h: HarmonyRange <- ranges) {
      if (h.inside(x, y))
        return h.chord
    }
    Cmaj7
  }
}
