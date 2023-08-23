<template>
    <div class="home">
      <header class= "nav-bar">
        <nav-bar />
      </header>
  
      <aside class="side-bar">
        <side-bar /> 
      </aside>
      
      <main class="saturday-card">
        <saturday-card/>
      </main>
  
      <footer class="footer">
        <h4>&#169; Nick Ngouma</h4>
      </footer>
      
    </div>
  </template>
  
  <script>
  import SaturdayCard from "../components/SaturdayCard.vue";
  import NavBar from "../components/NavBar.vue";
  import SideBar from "../components/SideBar.vue";
  export default {
    name: "sunday",
    components:{
      SaturdayCard, NavBar, SideBar
    }
  };
  </script>
  <style scoped>
  
  .nav-bar{
    grid-area: nav-bar;
  }
  
  .side-bar{
    grid-area: side-bar;
    height: 100%;
   
  }
  .saturday-card{
    grid-area: saturday-card;
    background-color: rgb(211, 231, 239);
    box-shadow: inset 0px 5px 5px 0px rgb(175, 166, 166);
  }
  .footer{
    grid-area: footer;
    background-color: yellow;
    text-align: center;
  }
    
  .home{
      height: 100vh;
      margin: 0;
      display: grid;
      grid-template-columns: 1fr 5fr;
      grid-template-areas: 
      "nav-bar nav-bar"
      "side-bar saturday-card"
      "footer footer";
  }
  
  
  </style>