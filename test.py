import lyricsgenius
from langdetect import detect
genius = lyricsgenius.Genius("dBNV46R1h2UMxXgLEJPtIwm0_WlVKKJ1TrVu7eYlr-pdv_kikEPRAmdJPv-gkIIY")
#artist = genius.search_artist("Andy Shauf", max_songs=3, sort="title")
#print(artist.songs)

song = genius.search_song("Con Calma", "Daddy Yankee")
print(detect(song.lyrics))
if(detect(song.lyrics) == 'en'):
	print(song.lyrics)
else:
	print("NOT ENGLISH")

#artist.save_lyrics()
