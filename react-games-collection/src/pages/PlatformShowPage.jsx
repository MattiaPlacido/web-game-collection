import { useParams } from "react-router-dom";
import { useGeneralContext } from "../contexts/GeneralContext";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import GameCard from "../components/GameCard";

export default function PlatformShowPage() {
    const [platform, setPlatform] = useState(null);
    const [filteredGames, setFilteredGames] = useState([]);
    const { data } = useGeneralContext();
    const { loading, error, gamesList, platformsList } = data;
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        if (platformsList) {
            setPlatform(platformsList.find((unfilteredPlatform) => unfilteredPlatform.id.toString() === id))
        }
    }, [id, platformsList]);

    useEffect(() => {
        if (gamesList && platform) {
            const filtered = gamesList.filter((game) =>
                game.platforms.some((filteredPlatform) => filteredPlatform.id === platform.id)
            );
            setFilteredGames(filtered);
        }
    }, [gamesList, platform]);

    if (loading) {
        return <h1 className="text-center">Loading...</h1>
    }


    if (error) {
        navigate("/error");
        return null;
    }

    return (
        <>
            {platform && gamesList && filteredGames ? (
                <div className="container my-5 text-white">
                    <div className="row">
                        <div className="col-12 text-center mb-5">
                            <h1 className="display-4">{platform.name}</h1>
                            <p className="lead text-secondary">{platform.description}</p>
                            <p className="lead"><span className="text-secondary">Publishing Company:</span> {platform.publishingCompany}</p>
                        </div>
                    </div>
                    <h3 className="text-secondary text-center">Games on this Platform</h3>
                    <div className="row justify-content-center">
                        {filteredGames.length > 0 ? (

                            filteredGames.map((game) => (
                                <div className="col-6 mb-4" key={game.id}>
                                    <GameCard gameData={game} />
                                </div>
                            ))

                        ) : (
                            <h3 className="text-center">No games found for this platform.</h3>
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
