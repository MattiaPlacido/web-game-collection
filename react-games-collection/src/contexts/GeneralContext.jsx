import { createContext, useContext, useEffect, useState } from "react";
import axios from "axios";

const GeneralContext = createContext();

export const useGeneralContext = () => useContext(GeneralContext);

export const GeneralContextProvider = ({ children }) => {
    //Variables
    const [gamesList, setGamesList] = useState([]);
    const [genresList, setGenresList] = useState([]);
    const [platformsList, setPlatformsList] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    //Methods
    const getGamesList = () => {
        axios.get(import.meta.env.VITE_GAMES_API_URL)
            .then((res) => {
                setGamesList(res.data);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    };

    const getGenresList = () => {
        axios.get(import.meta.env.VITE_GENRES_API_URL)
            .then((res) => {
                setGenresList(res.data);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    }

    const getPlatformsList = () => {
        axios.get(import.meta.env.VITE_PLATFORMS_API_URL)
            .then((res) => {
                setPlatformsList(res.data);
                setLoading(false);
            })
            .catch((err) => {
                setError(err.message);
                setLoading(false);
            });
    }


    const getGamesListByName = async (searchTerm) => {
        try {
            setLoading(true);
            const response = await axios.get(import.meta.env.VITE_GAMES_API_URL + "?name=" + searchTerm)
            console.log((import.meta.env.VITE_GAMES_API_URL + "?name=" + searchTerm));
            setLoading(false);
            return response.data;
        } catch (err) {
            setLoading(false);
        }
    };

    const getPlatformsListByName = async (searchTerm) => {
        try {
            setLoading(true);
            const response = await axios.get(import.meta.env.VITE_PLATFORMS_API_URL + "?name=" + searchTerm)
            setLoading(false);
            return response.data;
        } catch (err) {
            setLoading(false);
        }
    };

    const getGenresListByName = async (searchTerm) => {
        try {
            setLoading(true);
            const response = await axios.get(import.meta.env.VITE_GENRES_API_URL + "?name=" + searchTerm)
            setLoading(false);
            return response.data;
        } catch (err) {
            setLoading(false);
        }
    };

    useEffect(() => {
        getGamesList();
        getGenresList();
        getPlatformsList();
    }, []);

    //Data processing
    const data = {
        error,
        loading,
        gamesList,
        platformsList,
        genresList,
        getGamesListByName,
        getPlatformsListByName,
        getGenresListByName,
    }

    return (
        <GeneralContext.Provider value={{ data }}>
            {children}
        </GeneralContext.Provider>
    )
}
