import React from 'react';
import Main from './pages/Main';
import Draw from './pages/Draw';
import Result from './pages/Result';
import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <Routes>
      <Route path="" element={<Main />} />
      <Route path="/draw" element={<Draw />} />
      <Route path="/result" element={<Result />} />
    </Routes>
  );
}

export default App;
