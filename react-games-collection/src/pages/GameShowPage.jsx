import { useParams } from "react-router-dom";
import { useGeneralContext } from "../contexts/GeneralContext";
import { useEffect, useState } from "react";
import PlatformCard from "../components/PlatformCard";
import GenreCard from "../components/GenreCard";
import { useNavigate } from "react-router-dom";


export default function GameShowPage() {
    const [game, setGame] = useState();
    const { data } = useGeneralContext();
    const { gamesList, loading, error } = data;
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        if (gamesList) {
            setGame(gamesList.find((game) => game.id.toString() === id));
        }
    }, [id, gamesList]);


    if (loading) {
        return <h1 className="text-center">Loading...</h1>
    }

    if (error) {
        navigate("/error");
        return null;
    }


    return (
        <>
            {game ? (
                <div className="container my-5 text-white">
                    <div className="row">
                        <div className="col-6">
                            <img
                                src={game.imageUrl}
                                alt={game.name}
                                className="img-fluid"
                            />
                        </div>

                        <div className="col-6 d-flex flex-column justify-content-between">
                            <h1 className="display-4">{game.name}</h1>
                            <p className="lead text-secondary fs-3">{game.description}</p>
                            <div className="d-flex justify-content-between mt-3 fs-4">
                                <div>
                                    <strong>Release Date:</strong> {game.releaseDate}
                                </div>
                                <div>
                                    <strong>Publisher:</strong> {game.publisher}
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="row mt-5">
                        <div className="col-6">

                            <h4 className="fw-bold text-center">Genres</h4>
                            {game.genres.map((genre) => (
                                <div className="col-12 mb-1">
                                    <GenreCard genreData={genre} key={genre.id} />
                                </div>
                            ))}
                        </div>
                        <div className="col-6">

                            <h4 className="fw-bold text-center">Platforms</h4>
                            {game.platforms.map((platform) => (
                                <div className="col-12 mb-1" >
                                    <PlatformCard platformData={platform} key={platform.id} />
                                </div>
                            ))}
                        </div>
                    </div>
                </div >
            ) : (
                <h1 className="text-center">Something went wrong.</h1>
            )
            }
        </>
    );
}
