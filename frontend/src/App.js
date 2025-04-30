import React, { useEffect, useState } from 'react';
import './App.css';

function App() {
  const [randomStand, setStand] = useState(null);

  const fetchRandomStand = () => {
    fetch('http://localhost:8080/random')
      .then(res => res.json())
      .then(data => setStand(data))
      .catch(err => console.error(err));
  };
  const getYoutubeEmbedUrl = (url) => {
    const videoId = url.includes('watch?v=') 
      ? url.split('watch?v=')[1].split('&')[0]
      : url.split('youtu.be/')[1]?.split('?')[0];
    return `https://www.youtube.com/embed/${videoId}`;
  };

  useEffect(() => {
    fetchRandomStand();
  }, []);

  return (
    <div className="container">
    {randomStand ? (
      <div className="stand-info">
        <title>JoJo Stand Generator</title>

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
        <button onClick={fetchRandomStand} className="generate-button">GENERATE</button>
        
      </div>
      ) : (
        <p>Error while fetching data from the API. Is backend running?</p>
      )}

      <footer>
        <h2>Built by <a href="https://github.com/VitorRenanSD"target="_rel=noopener">Vitor Dias</a> and <a href="https://github.com/Kimiouskkjk"target="_rel=noopener">Ismael Porto</a></h2>
        <h2>Link to GitHub repository <a href="https://github.com/vitorrenansd/jojo-stands-rest-api"target="_rel=noopener">here</a></h2>
      </footer>     
    </div>
  );
}

export default App;