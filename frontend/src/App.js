import React, { useEffect, useState } from 'react';

function App() {
  const [randomStand, setStand] = useState(null);

  useEffect(() => {
    fetch('http://localhost:8080/random')
      .then(res => res.json())
      .then(data => setStand(data))
      .catch(err => console.error('Erro ao buscar stand aleatorio', err));
  }, []);

  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      {randomStand ? (
        <div>
          <p><strong>Stand name: </strong> {randomStand.stand}</p>
          <p><strong>Stand user: </strong> {randomStand.user}</p>
        </div>
      ) : (
        <p>Carregando...</p>
      )}
    </div>
  );
}

export default App;
