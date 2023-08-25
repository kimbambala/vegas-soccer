<template>
    <div class="home">
      <header class= "nav-bar">
        <nav-bar />
      </header>

      <div class="greeting">Hello {{ $store.state.user.username }}!</div>

      <h1>My groups</h1>
      <br><br>
      <div class="add-group">
        <button>
          <router-link v-bind:to="{ name: 'create', params:{userId: $store.state.user.id}}"><p>Add a new group</p></router-link>
        </button>
      </div>
      <br><br>
      <div class="group-card">
        <my-groups-card/>

      </div>
      


      <footer class="footer">
        <h4>&#169; Nick Ngouma</h4>
      </footer>
      
    </div>
  </template>
  
  <script>
import NavBar from '../components/NavBar.vue';
import MyGroupsCard from '../components/MyGroupsCard.vue';

  export default {
    name: "profile",
    components:{
      NavBar, MyGroupsCard
    }
  };
  </script>
  <style>

.greeting{
    margin-top: 10px;
    font-size: 25px;
    margin-left: 10px;
    text-transform: capitalize;
  }
  
  
  </style>