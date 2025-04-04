import { Outlet } from "react-router-dom";
import Footer from "./Footer";
import Navbar from "./Navbar";

export default function DefaultLayout() {
  return (
    <>
      <div className="wrapper d-flex flex-column min-vh-100">
        <div className="position-sticky z-1 top-0 bg-dark">
          <Navbar />
        </div>

        <div className="flex-grow-1 bg-black overflow-hidden">
          <Outlet />
        </div>

        <div className="position-sticky bg-dark bottom-0">
          <Footer />
        </div>
      </div>
    </>
  );
}
