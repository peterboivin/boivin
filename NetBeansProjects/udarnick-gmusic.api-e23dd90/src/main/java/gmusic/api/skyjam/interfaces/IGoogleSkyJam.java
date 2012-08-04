package gmusic.api.skyjam.interfaces;

import gmusic.api.interfaces.IGoogleMusicAPI;
import gmusic.api.skyjam.model.Playlists;
import gmusic.api.skyjam.model.Track;
import gmusic.api.skyjam.model.TrackFeed;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.apache.http.client.ClientProtocolException;

public interface IGoogleSkyJam extends IGoogleMusicAPI
{
	Collection<Track> getAllTracks() throws ClientProtocolException, IOException, URISyntaxException;

	Collection<File> downloadTracks(Collection<Track> tracks) throws URISyntaxException, ClientProtocolException, IOException;

	File downloadTrack(Track track) throws URISyntaxException, ClientProtocolException, IOException;

	Playlists getAllSkyJamPlaylists() throws ClientProtocolException, IOException, URISyntaxException;

	TrackFeed getSkyJamPlaylist(String plID) throws ClientProtocolException, IOException, URISyntaxException;

	URI getTrackURL(Track track) throws URISyntaxException, ClientProtocolException, IOException;
}
