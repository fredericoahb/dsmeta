import logo from '../../assets/img/logo-dsmeta.svg';
import './style.css';

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="DSMeta" />
                <h1>DSMeta</h1>
                <p>
                    Desenvolvido por
                    <a href="https://www.instagram.com/joiamarketing/" target="_blank">
                        @joiamarketing
                    </a>
                </p>
            </div>
        </header>
    )
}

export default Header;