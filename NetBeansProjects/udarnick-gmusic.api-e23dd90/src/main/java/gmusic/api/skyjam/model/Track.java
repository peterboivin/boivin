package gmusic.api.skyjam.model;

import gmusic.model.Tune;

import java.util.Collection;

public class Track extends Tune
{
	private int discNumber;
	private int totalDiscCount;
	private Collection<AlbumArtRef> albumArtRef;
	private int trackNumber;
	private int totalTrackCount;
	private String clientId;
	private long estimatedSize;
	private long creationTimestamp;
	private long lastModifiedTimestamp;

	public final void setId(String id)
	{
		this.id = id;
	}
	public final String getClientId()
	{
		return clientId;
	}
	public final long getCreationTimestamp()
	{
		return creationTimestamp;
	}
	public final long getLastModifiedTimestamp()
	{
		return lastModifiedTimestamp;
	}

	public final void setTitle(String title)
	{
		this.title = title;
	}

	public final int getTrackNumber()
	{
		return trackNumber;
	}

	public final Collection<AlbumArtRef> getAlbumArtRef()
	{
		return albumArtRef;
	}
	public final int getTotalTrackCount()
	{
		return totalTrackCount;
	}
	public final int getDiscNumber()
	{
		return discNumber;
	}
	public final int getTotalDiscCount()
	{
		return totalDiscCount;
	}
	public final long getEstimatedSize()
	{
		return estimatedSize;
	}

}
