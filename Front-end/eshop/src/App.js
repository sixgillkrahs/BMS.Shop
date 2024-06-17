import logo from './logo.svg';
import './App.css';
import Header from './Components/Header/Header';
import Footer from './Components/Footer/Footer';
import Index from './Pages/Index';
import Shop from './Pages/Shop';
import ProductDetail from './Pages/ProductDetail';
import LoginRegister from './Pages/LoginRegister';


const {BrowserRouter,Routes,Route} = require('react-router-dom');

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header/>
        <Routes>
          <Route path='/' element={<Index/>}></Route>
          <Route path='/shop' element={<Shop/>}></Route>
          <Route path='/category/product/:id' element={<ProductDetail />}>
            <Route path=':Id' element={<ProductDetail />}></Route>
          </Route>
          <Route path='/login' element={<LoginRegister/>}></Route>
          <Route path='/register' element={<LoginRegister/>}></Route>
        </Routes>
        <Footer/>
      </BrowserRouter>
       
    </div>
  );
}

export default App;
