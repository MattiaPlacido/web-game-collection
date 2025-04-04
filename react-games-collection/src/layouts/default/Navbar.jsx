export default function Navbar() {
    return (
        <nav className="navbar navbar-expand-lg">
            <div className="container-fluid pb-2 d-flex gap-5">
                <a className="navbar-brand fw-bold fs-3 text-white" href="/games">Games Collection</a>
                <div className="collapse navbar-collapse d-flex gap-5" id="navbarNav">
                    <ul className="navbar-nav">
                        <a className="nav-link fw-bold fs-4 text-secondary" href="/genres">Genres</a>
                    </ul>
                    <ul className="navbar-nav">
                        <a className="nav-link fw-bold fs-4 text-secondary" href="/platforms">Platforms</a>
                    </ul>
                </div>
            </div>
        </nav>
    )
}