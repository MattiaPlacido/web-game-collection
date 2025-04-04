export default function PlatformCard({ platformData }) {
    return (
        <a className="text-decoration-none" href={`/platforms/${platformData.id}`}>
            <div className="card bg-dark text-white p-3 h-100">
                <h5 className="mb-4">{platformData.name}</h5>
                <p><strong>Description:</strong> {platformData.description}</p>
                <p><strong>Publisher:</strong> {platformData.publishingCompany}</p>
            </div>
        </a>
    )
}