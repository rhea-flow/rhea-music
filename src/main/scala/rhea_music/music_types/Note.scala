package rhea_music.music_types

import rhea_music.ImplicitConversions._

import rhea_music.constants.Durations.Duration
import rhea_music.constants.Durations._
import rhea_music.constants.NoteMods.NoteMod
import rhea_music.constants.NoteMods._
import rhea_music.constants.Octaves.Octave
import rhea_music.constants.Octaves._
import rhea_music.constants.Tones.Tone
import rhea_music.constants.Tones._
import rhea_music.music_streams.MusicStream
import rhea_music.util.Random.randNote

/**
  * @author Orestis Melkonian
  */
class Note(var tone: Tone = C,
           var mod: NoteMod = noNoteMod,
           var octave: Octave = noOctave,
           var duration: Duration = quarter
          ) extends MusicString {

  override def repr: String = tone + mod + (if (octave == noOctave) "" else octave) + duration

  def clean: Note = {
    octave = noOctave
    duration = noDuration
    if (mod == n)
      mod = noNoteMod
    this
  }

}

object Note {
  def randNotes: MusicStream = MusicStream.repeatFunc(randNote)
}
