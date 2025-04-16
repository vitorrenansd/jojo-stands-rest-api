import React, { useEffect, useState } from 'react';

function App() {
  const [allStands, setAllStands] = useState([]);
  const [randomStand, setRandomStand] = useState(null);

  useEffect(() => {
    fetch('http://localhost:8080/all')
      .then(res => res.json())
      .then(data => setAllStands(data))
      .catch(err => console.error('Erro ao buscar todos os Stands:', err));

    fetch('http://localhost:8080/random')
      .then(res => res.json())
      .then(data => setRandomStand(data))
      .catch(err => console.error('Erro ao buscar Stand aleatório:', err));
  }, []);

  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>🌀 Lista de Stands</h1>
      <ul>
        {allStands.map((stand, index) => (
          <li key={index}>
            <strong>{stand.name}</strong> - {stand.power}
          </li>
        ))}
      </ul>

      <h2>🎲 Stand Aleatório</h2>
      {randomStand ? (
        <div>
          <p><strong>Nome:</strong> {randomStand.name}</p>
          <p><strong>Poder:</strong> {randomStand.power}</p>
        </div>
      ) : (
        <p>Carregando...</p>
      )}
    </div>
  );
}

export default App;
