package log.charter.io.rs.xml.song;

import static java.lang.Math.max;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import log.charter.io.rs.xml.converters.TimeConverter;
import log.charter.song.Chord;
import log.charter.song.HandShape;
import log.charter.song.Note;

@XStreamAlias("handShape")
public class ArrangementHandShape {
	@XStreamAsAttribute
	public int chordId;
	@XStreamAsAttribute
	@XStreamConverter(TimeConverter.class)
	public int startTime;
	@XStreamAsAttribute
	@XStreamConverter(TimeConverter.class)
	public int endTime;

	public ArrangementHandShape() {
	}

	public ArrangementHandShape(final Chord chord) {
		chordId = chord.chordId;
		startTime = chord.position;
		endTime = chord.position + 50;
		for (final Note chordNote : chord.chordNotes) {
			endTime = max(endTime, chordNote.position + chordNote.sustain);
		}
	}

	public ArrangementHandShape(final HandShape handShape, final int chordId) {
		this.chordId = chordId;
		startTime = handShape.position;
		endTime = startTime + handShape.length;
	}
}