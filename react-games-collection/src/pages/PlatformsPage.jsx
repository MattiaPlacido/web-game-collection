import { useGeneralContext } from "../contexts/GeneralContext";
import PlatformCard from "../components/PlatformCard";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";

export default function PlatformPage() {
    const { data } = useGeneralContext();
    const { error, loading, platformsList, getPlatformsListByName } = data;
    const [filteredPlatforms, setFilteredPlatforms] = useState(platformsList);

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
        const getPlatforms = async () => {
            if (debouncedSearchTerm && debouncedSearchTerm != "") {
                const results = await getPlatformsListByName(searchTerm);
                setFilteredPlatforms(results);
            } else {
                setFilteredPlatforms(platformsList);
            }
        };

        getPlatforms();
    }, [debouncedSearchTerm, platformsList]);

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
                    placeholder="Search platforms by name..."
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    className="form-control"
                />
            </div>
            {filteredPlatforms && filteredPlatforms.length > 0 ? (
                <div className="row justify-content-center mt-5 d-flex">
                    {filteredPlatforms.map((platform) => (
                        <div className="mx-2 mb-4 col-3 ">
                            <PlatformCard platformData={platform} />
                        </div>
                    ))}
                </div>
            ) : <h1 className="text-white text-center">No platforms available.</h1>}
        </>
    )
}