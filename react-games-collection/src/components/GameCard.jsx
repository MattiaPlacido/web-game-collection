import styles from "./components.module.css";

export default function GameCard({ gameData }) {
    return (
        <>
            <a className="text-decoration-none" href={`/games/${gameData.id}`}>
                <div className="card p-0 border-dark bg-dark text-white h-100" key={gameData.id}>
                    <img className={`card-img-top ` + styles.card_image} src={gameData.imageUrl} alt="Card image cap" />
                    <div className="card-body">
                        <h5 className="card-title">{gameData.name}</h5>
                        <p className="card-text">{gameData.description}</p>
                    </div>
                    <div className="row p-3">
                        <div className="col-6">
                            <ul className="list-group list-group-flush">
                                <li className="fw-bold list-group-item text-center bg-dark text-white mb-1">Platforms</li>
                                {gameData.platforms.map((platform) => (
                                    <li className="list-group-item  badge border-secondary border bg-dark text-white" key={platform.id}>{platform.name}</li>
                                ))}
                            </ul>
                        </div>
                        <div className="col-6">

                            <ul className="list-group list-group-flush">
                                <li className="fw-bold list-group-item text-center bg-dark text-white mb-1">Genres</li>
                                {gameData.genres.map((genre) => (
                                    <li className="list-group-item badge border-secondary border bg-dark text-white" key={genre.id}>{genre.name}</li>
                                ))}
                            </ul>
                        </div>
                    </div>
                </div>
            </a>

        </>
    )
}