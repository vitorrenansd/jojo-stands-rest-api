import React, { useEffect, useState } from 'react';

function App() {
  const [RandomStand, setStand] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/stand')
      .then(res => res.json())
      .then(data => setStand(data))
      .catch(err => console.error('Erro ao buscar stand aleatorio', err));
  }, []);

  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>🌀 Lista de Stands</h1>
      <ul>
        {RandomStand.map((stand, index) => (
          <li key={index}>
            <strong>{stand.stand}</strong> - {stand.user}
          </li>
        ))}
      </ul>

      <h2>Stand Aleatório</h2>
      {RandomStand ? (
        <div>
          <p><strong>Nome:</strong> {RandomStand.stand}</p>
          <p><strong>Usuario:</strong> {RandomStand.user}</p>
        </div>
      ) : (
        <p>Carregando...</p>
      )}
    </div>
  );
}

export default App;
