import { useParams } from "react-router-dom";
import { useGeneralContext } from "../contexts/GeneralContext";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import GameCard from "../components/GameCard";

export default function GenreShowPage() {
    const [genre, setGenre] = useState(null);
    const [filteredGames, setFilteredGames] = useState([]);
    const { data } = useGeneralContext();
    const { loading, error, gamesList, genresList } = data;
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        if (genresList) {
            setGenre(genresList.find((gen) => gen.id.toString() === id));
        }
    }, [id, genresList]);

    //Al cambio di genere triggera lo useEffect, se la logica di filtraggio viene messa sopra non funziona perchè genre deve avere il tempo di aggiornarsi essendo una variabile dinamica, altrimenti l'assegnazione è istantanea e risulta undefined
    useEffect(() => {
        if (gamesList && genre) {
            const filtered = gamesList.filter((game) =>
                game.genres.some((gameGenre) => gameGenre.id === genre.id)
            );
            setFilteredGames(filtered);
        }
    }, [gamesList, genre]);

    if (loading) {
        return <h1 className="text-center">Loading...</h1>
    }


    if (error) {
        navigate("/error");
        return null;
    }

    return (
        <>
            {genre && gamesList && filteredGames ? (
                <div className="container my-5 text-white">
                    <div className="row">
                        <div className="col-12 text-center mb-5">
                            <h1 className="display-4">{genre.name}</h1>
                            <p className="lead text-secondary">{genre.description}</p>
                            <p className="lead"><span className="text-secondary">Target audience :</span> {genre.targetAudience}</p>
                        </div>
                    </div>
                    <h3 className="text-secondary text-center">Games with this Genre</h3>
                    <div className="row justify-content-center">
                        {filteredGames.length > 0 ? (
                            filteredGames.map((game) => (
                                <div className="col-6 mb-4" key={game.id}>
                                    <GameCard gameData={game} />
                                </div>
                            ))
                        ) : (
                            <h3 className="text-center">No games found in this genre.</h3>
                        )}
                    </div>
                </div>
            ) : (
                <div className="text-center">
                    <h1>Something went wrong.</h1>
                </div>
            )}
        </>
    );
}
