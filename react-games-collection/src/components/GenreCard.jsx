export default function GenreCard({ genreData }) {
    return (
        <a href={`/genres/${genreData.id}`} className="text-decoration-none">
            <div className="card bg-dark text-white p-3 h-100 d-flex flex-column justify-content-between">
                <h5 className="mb-4">{genreData.name}</h5>
                <p><strong>Description:</strong> {genreData.description}</p>
                <p><strong>Target Audience:</strong> {genreData.targetAudience}</p>
            </div>
        </a>
    )
}