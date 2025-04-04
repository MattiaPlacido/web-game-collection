import { useGeneralContext } from "../contexts/GeneralContext"
import GenreCard from "../components/GenreCard"
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";

export default function GenresPage() {
    const { data } = useGeneralContext();
    const { error, loading, genresList, getGenresListByName } = data;
    const [filteredGenres, setFilteredGenres] = useState(genresList)

    const [searchTerm, setSearchTerm] = useState("");
    const [debouncedSearchTerm, setDebouncedSearchTerm] = useState(searchTerm);

    const navigate = useNavigate();

    useEffect(() => {
        //Ogni 500ms aggiorna debouncedTerm a searchTerm, per non spammare richieste a ogni lettera che viene cercata
        const timeout = setTimeout(() => {
            setDebouncedSearchTerm(searchTerm);
        }, 500);

        // Se l'utente digita più velocemente del tempo di debounce, questo clear cancella il timer precedente "aspettando" che l'utente finisca di digitare e non aggiornando arbitrariamente la ricerca ogni 500ms
        // quindi chiamando solo l'ultima richiesta ed evitando di fare multiple chiamate inutili
        return () => clearTimeout(timeout);

    }, [searchTerm]);

    useEffect(() => {
        const getGenres = async () => {
            if (debouncedSearchTerm && debouncedSearchTerm != "") {
                const results = await getGenresListByName(searchTerm);
                setFilteredGenres(results);
            } else {
                setFilteredGenres(genresList);
            }
        };

        getGenres();
    }, [debouncedSearchTerm, genresList]);

    if (loading) {
        return <h1 className="text-center">Loading...</h1>
    }


    if (error) {
        navigate("/error");
        return null;
    }

    return (
        <>
            <div className="search-bar container text-center my-3">
                <input
                    type="search"
                    placeholder="Search genres by name..."
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    className="form-control"
                />
            </div>
            {filteredGenres && filteredGenres.length > 0 ? (
                <div className="row justify-content-center mt-5 d-flex">
                    {filteredGenres.map((genre) => (
                        <div className="mx-2 mb-4 col-3 ">
                            <GenreCard genreData={genre} />
                        </div>
                    ))}
                </div>
            ) : <h1 className="text-center text-white">No genres available.</h1 >}
        </>
    )

}