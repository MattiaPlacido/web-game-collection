import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';
import './App.css';

import { GeneralContextProvider } from './contexts/GeneralContext';
import DefaultLayout from './layouts/default/DefaultLayout';
import ErrorHandlingPage from './pages/ErrorHandlingPage';
import GamesPage from './pages/GamesPage';
import GameShowPage from './pages/GameShowPage';
import GenresPage from './pages/GenresPage';
import GenreShowPage from './pages/GenreShowPage';
import PlatformPage from './pages/PlatformsPage';
import PlatformShowPage from './pages/PlatformShowPage';


function App() {
  return (
    <GeneralContextProvider>
      <BrowserRouter>
        <Routes>
          <Route element={<DefaultLayout />}>
            <Route path="/" element={<Navigate to="/games" />} />
            <Route path="/games" element={<GamesPage />} />
            <Route path="/games/:id" element={<GameShowPage />} />
            <Route path="/genres" element={<GenresPage />} />
            <Route path="/genres/:id" element={<GenreShowPage />} />
            <Route path="/platforms" element={<PlatformPage />} />
            <Route path="/platforms/:id" element={<PlatformShowPage />} />
            <Route path="*" element={<ErrorHandlingPage />} />
          </Route>

        </Routes>
      </BrowserRouter>
    </GeneralContextProvider>
  );
}

export default App;
