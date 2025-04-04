import { useGeneralContext } from "../contexts/GeneralContext";

export default function ErrorHandlingPage() {
    const { data } = useGeneralContext();
    const { error } = data;

    return (
        <div className="text-center text-white mt-5">
            <h1>Error</h1>
            <h1>{error}</h1>
            <p>The page you are looking for doesn't exist.</p>
        </div>
    );
}
