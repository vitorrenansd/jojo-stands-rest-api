import React, { useEffect, useState } from 'react';
import './App.css';

function App() {
  const [randomStand, setStand] = useState(null);

  useEffect(() => {
    fetch('http://localhost:8080/random')
      .then(res => res.json())
      .then(data => setStand(data))
      .catch(err => console.error('Erro ao buscar stand aleatorio', err));
  }, []);

  const getYoutubeEmbedUrl = (url) => {
    const videoId = url.includes('watch?v=') 
      ? url.split('watch?v=')[1].split('&')[0]
      : url.split('youtu.be/')[1]?.split('?')[0];
    return `https://www.youtube.com/embed/${videoId}`;
  };

  return (
    <div className="container">
    {randomStand ? (
      <div className="stand-info">
        <h1>Jojo Stand Viewer</h1>
        <div className="stand-name">{randomStand.stand}</div>
        <div className="stand-user">User: {randomStand.user}</div>

        {randomStand.imageUrl && (
          <img
            className="stand-img"
            src={randomStand.imageUrl}
            alt={randomStand.stand}
          />
        )}

        {randomStand.videoUrl && (
          <div className="video-wrapper">
            <iframe
              src={getYoutubeEmbedUrl(randomStand.videoUrl)}
              title="Stand Video"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
              allowFullScreen
            ></iframe>
          </div>
        )}
      </div>
    ) : (
        <p>Error while fetching data from the API</p>
      )}
    </div>
  );
}

export default App;
