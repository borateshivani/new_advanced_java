import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.css"
import MyHeader from './components/MyHeader';
import MyFooter from './components/MyFooter';
import MainNavBar from './components/MainNavBar'
import {Routes,Route,Navigate} from 'react-router-dom'
import ProductFormcomponent from './pages/ProductFormcomponent';
import ProductTabComponent from './pages/ProductTabComponent';
import CategoryTabComponent from './pages/CategoryTabComponent';
import HomeComponent from './pages/HomeComponent';
import Aboutus from './pages/Aboutus';
import ProductEditForm from './pages/ProductEditForm';
import ViewProductDetails from './pages/ViewProductDetails';
function App() {
  return (
    <div>
        <MyHeader></MyHeader>
        <MainNavBar></MainNavBar>
        <Routes>
        <Route path="/" element={<Navigate replace to="/home"></Navigate> }></Route>
        <Route path="/home" element={<HomeComponent></HomeComponent> }></Route>
        <Route path="/products" element={<ProductTabComponent></ProductTabComponent> }>
            <Route path="view/:prodid" element={<ViewProductDetails></ViewProductDetails>}></Route>
        </Route>
        <Route path="/categories" element={<CategoryTabComponent></CategoryTabComponent> }></Route>
        <Route path="/form" element={<ProductFormcomponent></ProductFormcomponent> }></Route>
        <Route path="/edit/:id" element={<ProductEditForm></ProductEditForm> }></Route>
        <Route path="/aboutus" element={<Aboutus></Aboutus> }></Route>
      </Routes>
        <MyFooter></MyFooter>
   </div>
  );
}

export default App;
