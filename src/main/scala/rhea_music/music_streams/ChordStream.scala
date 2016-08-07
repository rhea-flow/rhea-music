package rhea_music.music_streams

import rhea_music.ImplicitConversions._

import org.jfugue.theory.Chord
import org.rhea_core.Stream

import rhea_music.util.random.randChord

/**
  * @author Orestis Melkonian
  */
class ChordStream(val stream: Stream[Chord]) {

}

object ChordStream {
  def randChords: ChordStream =
    PatternStream.repeatFunc(randChord)
}




