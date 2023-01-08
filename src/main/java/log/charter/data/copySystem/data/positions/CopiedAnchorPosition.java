package log.charter.data.copySystem.data.positions;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import log.charter.song.Anchor;
import log.charter.song.Beat;

@XStreamAlias("copiedAnchor")
public class CopiedAnchorPosition extends CopiedPosition<Anchor> {
	@XStreamAsAttribute
	public final int fret;
	@XStreamAsAttribute
	public final int width;

	public CopiedAnchorPosition(final List<Beat> beats, final double baseBeatPosition, final Anchor anchor) {
		super(beats, baseBeatPosition, anchor);
		fret = anchor.fret;
		width = anchor.width;
	}

	@Override
	protected Anchor prepareValue() {
		final Anchor anchor = new Anchor();
		anchor.fret = fret;
		anchor.width = width;

		return anchor;
	}
}